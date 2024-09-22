package com.org.litness.data.repository

import com.org.litness.base.MResult
import com.org.litness.ui.exercise.model.Exercise
import com.org.litness.ui.exercise.model.FocusArea
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExerciseRepository @Inject constructor() {

    fun getAllExercise(filters: List<Int>): Flow<MResult<List<Exercise>>> {
        return flow {
            emit(
                MResult.Success(
                    listOf(
                        Exercise(1, "Crunch", "aa", "Abs"),
                        Exercise(1, "Crunch", "aa", "Abs"),
                        Exercise(1, "Crunch", "aa", "Abs"),
                        Exercise(1, "Crunch", "aa", "Abs"),
                        Exercise(1, "Crunch", "aa", "Abs"),
                        Exercise(1, "Crunch", "aa", "Abs"),
                    )
                )
            )
        }
    }

    fun getDetail(id: Int): Flow<MResult<Exercise>> {
        return flow {

        }
    }

    fun getFocusAreas(): MResult<List<FocusArea>> {
        return MResult.Success(
            listOf(
                FocusArea(id = 1, "Abs"),
                FocusArea(id = 2, "Arm"),
                FocusArea(id = 3, "Back"),
                FocusArea(id = 4, "Chest"),
                FocusArea(id = 5, "Leg"),
            )
        )
    }
}