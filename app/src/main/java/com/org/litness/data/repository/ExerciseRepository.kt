package com.org.litness.data.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.org.litness.base.MResult
import com.org.litness.data.source.model.FocusAreaFB
import com.org.litness.ui.exercise.model.Exercise
import com.org.litness.ui.exercise.model.FocusArea
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ExerciseRepository @Inject constructor() {

    private val focusAreaDbRef: DatabaseReference = Firebase.database.getReference("FocusArea")
    private val exerciseDbRef: DatabaseReference = Firebase.database.getReference("Exercises")

    fun getAllExercise(filters: List<Long>): Flow<MResult<List<Exercise>>> {
        return callbackFlow {
            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val exercises = mutableListOf<Exercise>()

                    val hashSet = HashSet<Long>()
                    for(filter in filters) {
                        hashSet.add(filter)
                    }

                    for(data in snapshot.children) {
                        val id = data.child("id").getValue(String::class.java) ?: ""
                        val imgUrl = data.child("imgUrl").getValue(String::class.java) ?: ""
                        val steps = data.child("steps").getValue(String::class.java) ?: ""
                        val title = data.child("title").getValue(String::class.java) ?: ""
                        val metScore = data.child("metScore").getValue(Double::class.java) ?: 0.0

                        val focusAreas = data.child("focusAreas")
                        val listFocusArea = mutableListOf<FocusAreaFB>()
                        for(area in focusAreas.children) {
                            val fa = area.getValue(FocusAreaFB::class.java)
                            fa?.let {
                                listFocusArea.add(it)
                            }
                        }

                        if(hashSet.isNotEmpty()) {
                            var ok = false
                            for(area in listFocusArea) {
                                if(hashSet.contains(area.id.toLong())) {
                                    ok = true
                                    break
                                }
                            }

                            if(ok) {
                                exercises.add(
                                    Exercise(
                                        id = id,
                                        imgUrl = imgUrl,
                                        title = title,
                                        steps = steps,
                                        metScore = metScore,
                                        focusArea = focusAreasToString(listFocusArea)
                                    )
                                )
                            }
                            continue
                        }

                        exercises.add(
                            Exercise(
                                id = id,
                                imgUrl = imgUrl,
                                title = title,
                                steps = steps,
                                metScore = metScore,
                                focusArea = focusAreasToString(listFocusArea)
                            )
                        )
                    }

                    trySend(MResult.Success(exercises))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(MResult.Error(error.message))
                }
            }

            exerciseDbRef.addListenerForSingleValueEvent(listener)

            awaitClose {
                exerciseDbRef.removeEventListener(listener)
            }
        }
    }

    fun getDetail(id: String): Flow<MResult<Exercise>> {
        return callbackFlow {
            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(data in snapshot.children) {
                        val mId = data.child("id").getValue(String::class.java) ?: ""
                        val imgUrl = data.child("imgUrl").getValue(String::class.java) ?: ""
                        val steps = data.child("steps").getValue(String::class.java) ?: ""
                        val title = data.child("title").getValue(String::class.java) ?: ""

                        val focusAreas = data.child("focusAreas")
                        val listFocusArea = mutableListOf<FocusAreaFB>()
                        for(area in focusAreas.children) {
                            val fa = area.getValue(FocusAreaFB::class.java)
                            fa?.let {
                                listFocusArea.add(it)
                            }
                        }

                        if(mId == id) {
                            trySend(MResult.Success(
                                Exercise(
                                    id = mId,
                                    imgUrl = imgUrl,
                                    title = title,
                                    steps = steps,
                                    focusArea = focusAreasToString(listFocusArea)
                                )))

                            return
                        }
                    }

                    trySend(MResult.Error("Not found"))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(MResult.Error(error.message))
                }

            }

            exerciseDbRef.addListenerForSingleValueEvent(listener)

            awaitClose {
                exerciseDbRef.removeEventListener(listener)
            }
        }
    }

    fun getFocusAreas(): Flow<MResult<List<FocusArea>>> {
        return callbackFlow {
            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val focusAreas = mutableListOf<FocusArea>()

                    for(data in snapshot.children) {
                        val focusArea = data.getValue(FocusAreaFB::class.java)
                        focusArea?.let {
                            focusAreas.add(
                                FocusArea(id = it.id.toLong(), name = it.name)
                            )
                        }
                    }

                    trySend(MResult.Success(focusAreas))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(MResult.Error(error.toException().message ?: ""))
                }
            }

            focusAreaDbRef.addListenerForSingleValueEvent(listener)

            awaitClose {
                focusAreaDbRef.removeEventListener(listener)
            }
        }
    }

    private fun focusAreasToString(list: List<FocusAreaFB>): String {
        if(list.isEmpty()) return ""

        val r = StringBuilder()
        for(i in list.indices) {
            if(i == list.size - 1) {
                r.append(list[i].name)
            } else {
                r.append(list[i].name)
                r.append(",")
            }
        }

        return r.toString().trim()
    }
}