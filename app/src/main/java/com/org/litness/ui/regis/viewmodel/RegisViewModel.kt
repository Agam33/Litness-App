package com.org.litness.ui.regis.viewmodel

import androidx.lifecycle.viewModelScope
import com.org.litness.base.BaseViewModel
import com.org.litness.base.MResult
import com.org.litness.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class RegisViewModel @Inject constructor(
    private val userRepository: UserRepository
): BaseViewModel<RegisUiState>(RegisUiState()) {

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            userRepository.signUp(email, password).collect { res ->
                when(res) {
                    is MResult.Success -> {
                        _uiState.update {
                            it.copy(message = res.data)
                        }
                    }
                     is MResult.Error -> {
                         _uiState.update {
                             it.copy(message = res.msg)
                         }
                     }
                }

                _uiState.update {
                    it.copy(message = null)
                }
            }
        }
    }
}