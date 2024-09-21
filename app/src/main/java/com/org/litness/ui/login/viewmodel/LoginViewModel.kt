package com.org.litness.ui.login.viewmodel

import androidx.lifecycle.viewModelScope
import com.org.litness.base.BaseViewModel
import com.org.litness.base.MResult
import com.org.litness.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
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