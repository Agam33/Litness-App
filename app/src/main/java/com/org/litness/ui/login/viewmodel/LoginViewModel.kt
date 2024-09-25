package com.org.litness.ui.login.viewmodel

import androidx.lifecycle.viewModelScope
import com.org.litness.base.BaseViewModel
import com.org.litness.base.MResult
import com.org.litness.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): BaseViewModel<LoginUiState>(LoginUiState()) {

    fun login(email: String, password: String) {
        viewModelScope.launch {
            userRepository.signIn(email, password).collect { res ->
                when(res) {
                    is MResult.Success -> {
                        _uiState.update {
                            it.copy(message = res.data)
                        }
                        setSuccess(true)
                        delay(10)
                        _uiState.update {
                            it.copy(message = null)
                        }
                    }
                    is MResult.Error -> {
                        _uiState.update {
                            it.copy(message = res.msg)
                        }
                        delay(500)
                        _uiState.update {
                            it.copy(message = null)
                        }
                    }
                }
            }
        }
    }

    private fun setSuccess(state: Boolean) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isSuccess = state)
            }

            delay(1)

            _uiState.update {
                it.copy(isSuccess = null)
            }
        }
    }
}