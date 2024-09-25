package com.org.litness.ui.profile.viewmodel

import androidx.lifecycle.viewModelScope
import com.org.litness.base.BaseViewModel
import com.org.litness.base.MResult
import com.org.litness.data.repository.UserRepository
import com.org.litness.ui.profile.ProfileUiState
import com.org.litness.ui.profile.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
): BaseViewModel<ProfileUiState>(ProfileUiState()) {

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        viewModelScope.launch {
            userRepository.getUserInfo().collect { res ->
              when(res) {
                  is MResult.Success -> {
                      _uiState.update {
                          it.copy(user = res.data?.copy())
                      }
                  }
                  else -> Unit
              }
            }
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.updateUser(user)
        }
    }

    fun logout() {
        userRepository.logout()
    }
}