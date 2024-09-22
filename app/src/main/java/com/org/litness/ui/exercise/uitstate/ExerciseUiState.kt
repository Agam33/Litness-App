package com.org.litness.ui.exercise.uitstate

import com.org.litness.ui.exercise.model.Exercise

data class ExerciseUiState(
    val exercises: List<Exercise> = emptyList(),
    val filters: HashSet<Int> = HashSet()
)
