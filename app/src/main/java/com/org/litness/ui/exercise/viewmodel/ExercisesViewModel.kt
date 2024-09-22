package com.org.litness.ui.exercise.viewmodel

import androidx.lifecycle.viewModelScope
import com.org.litness.base.BaseViewModel
import com.org.litness.base.MResult
import com.org.litness.data.repository.ExerciseRepository
import com.org.litness.ui.exercise.uitstate.ExerciseUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
): BaseViewModel<ExerciseUiState>(ExerciseUiState()) {

    init {
        getExercises()
    }

    fun getExercises(
        filters: List<Int> = emptyList()
    ) {
        viewModelScope.launch {
            exerciseRepository.getAllExercise(
                filters = uiState.value.filters.toList()
            ).collect { res ->
                when(res) {
                    is MResult.Success -> {
                        _uiState.update {
                            it.copy(
                                exercises = res.data ?: emptyList()
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    fun setFilter(id: Int) {
        val newFilter = uiState.value.filters
        newFilter.add(id)
        _uiState.update {
            it.copy(
                filters = newFilter
            )
        }
    }

    fun deleteFilter(id: Int) {
        val newFilter = uiState.value.filters
        newFilter.remove(id)
        _uiState.update {
            it.copy(
                filters = newFilter
            )
        }
    }
}