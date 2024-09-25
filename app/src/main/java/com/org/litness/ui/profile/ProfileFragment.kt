package com.org.litness.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.org.litness.R
import com.org.litness.databinding.FragmentProfileBinding
import com.org.litness.ui.login.LoginActivity
import com.org.litness.ui.profile.component.UserUpdateBottomSheet
import com.org.litness.ui.profile.model.User
import com.org.litness.ui.profile.viewmodel.ProfileViewModel
import com.org.litness.util.DrawerMenuToolbarListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment(), UserUpdateBottomSheet.OnRefreshListener {

    private var binding: FragmentProfileBinding? = null

    private val viewModel: ProfileViewModel by viewModels()

    var drawerMenuToolbarListener: DrawerMenuToolbarListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding!!) {
            toolbar.setNavigationOnClickListener { drawerMenuToolbarListener?.onDrawerMenuClicked() }
            btnUpdateUser.setOnClickListener {
                val updateBottomSheet = UserUpdateBottomSheet().apply { onRefreshListener = this@ProfileFragment }
                updateBottomSheet.show(childFragmentManager, "updateBottomSheet")
            }
            btnLogout.setOnClickListener {
                viewModel.logout()
                startActivity(
                    Intent(requireActivity(), LoginActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                )
            }
        }
        observer()
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

    private fun setupUser(user: User) = with(binding!!) {
        tvGender.text = user.gender
        tvWeight.text = String.format(requireContext().getString(R.string.txt_weight), user.weight)
        tvHeight.text = String.format(requireContext().getString(R.string.txt_height),user.height)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onRefresh() {
        viewModel.getUserInfo()
    }
}