package com.org.litness.ui.profile.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.org.litness.databinding.DialogFragmentUserUpdateBinding
import com.org.litness.ui.profile.model.User
import com.org.litness.ui.profile.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserUpdateBottomSheet: BottomSheetDialogFragment() {

    private val viewModel: ProfileViewModel by viewModels()

    private var _binding: DialogFragmentUserUpdateBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding!!) {
            btnCancel.setOnClickListener {
                dismiss()
            }
        }

        observer()
        updateUser()
    }

    private fun observer() {
        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                uiState.user?.let {
                    setupUser(it)
                }
            }
        }
    }

    private fun updateUser() = with(binding!!) {
        val weight = inputWeight.text.toString()
        val height = inputHeight.text.toString()

        if(height.isBlank() || weight.isBlank()) {
            return@with
        }

        val user = User(
            weight = weight.toDouble(),
            height = height.toDouble(),
            gender = if(radioMale.isChecked) "Pria" else "Wanita"
        )

        viewModel.updateUser(user)
    }

    private fun setupUser(user: User) = with(binding!!) {
        inputHeight.setText(user.height.toString())
        inputWeight.setText(user.weight.toString())

        if(user.gender.equals("Pria")) {
            radioMale.isChecked = true
        } else {
            radioFemale.isChecked = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogFragmentUserUpdateBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}