package com.org.litness.data.repository

import com.org.litness.base.MResult
import com.org.litness.ui.profile.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun signUp(email: String, password: String): Flow<MResult<String>> {
        return flow {

        }
    }

    fun signIn(email: String, password: String): Flow<MResult<String>> {
        return flow {

        }
    }

    fun getUserInfo(): Flow<MResult<User>> {
        return flow {
//            emit(MResult.Success(
//                User(
//                    weight = 55.0,
//                    height = 157.0,
//                    gender = "Pria"
//                )
//            ))
        }
    }

    suspend fun updateUser(user: User) {

    }

    suspend fun logout() {

    }
}