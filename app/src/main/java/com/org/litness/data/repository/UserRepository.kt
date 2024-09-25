package com.org.litness.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.org.litness.base.MResult
import com.org.litness.data.source.model.UserFB
import com.org.litness.ui.profile.model.User
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UserRepository @Inject constructor() {

    private val firebaseDb: DatabaseReference = Firebase.database.getReference("Users")
    private val auth: FirebaseAuth = Firebase.auth

    fun signUp(email: String, password: String): Flow<MResult<String>> {
        return callbackFlow {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    trySend(MResult.Success())
                }
                .addOnFailureListener {
                    trySend(MResult.Error(it.message ?: ""))
                }

            awaitClose {}
        }
    }

    fun signIn(email: String, password: String): Flow<MResult<String>> {
        return callbackFlow {
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { trySend(MResult.Success("Success Login")) }
                .addOnFailureListener { trySend(MResult.Error(it.message ?: "")) }
            awaitClose {}
        }
    }

    fun getUserInfo(): Flow<MResult<User>> {
        return callbackFlow {
            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(UserFB::class.java)
                    user?.let {
                        trySend(
                            MResult.Success(
                                User(gender = it.gender, weight = it.weight, height = it.height)
                            )
                        )
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(MResult.Error(error.message))
                }
            }

            firebaseDb
                .child(auth.currentUser?.uid ?: "")
                .addListenerForSingleValueEvent(listener)

            awaitClose {
                firebaseDb.removeEventListener(listener)
            }
        }
    }

    fun updateUser(user: User) {
        val userFB = UserFB(
            id = auth.currentUser?.uid ?: "",
            email = auth.currentUser?.email ?: "",
            weight = user.weight,
            height = user.height,
            gender = user.gender
        )

        firebaseDb
            .child(auth.currentUser?.uid ?: return)
            .setValue(userFB)
    }

   fun logout() {
        auth.signOut()
    }
}