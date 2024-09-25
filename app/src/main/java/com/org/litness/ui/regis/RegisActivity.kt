package com.org.litness.ui.regis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.org.litness.databinding.ActivityRegisBinding
import com.org.litness.ui.regis.viewmodel.RegisViewModel
import com.org.litness.util.showShortToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisActivity : AppCompatActivity() {

    private val viewModel: RegisViewModel by viewModels()

    private val binding: ActivityRegisBinding by lazy { ActivityRegisBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observer()

        binding.btnRegis.setOnClickListener {
            signUp()
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun observer() {
        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                uiState.message?.let {
                    showShortToast(it)
                }

                uiState.isSuccess?.let {
                    if(it) {
                        finish()
                    }
                }
            }
        }
    }

    private fun signUp() {
        val email: String = binding.inputEmail.editText?.text.toString()
        val password: String = binding.inputPassword.editText?.text.toString()

        if(email.isBlank()) {
            showShortToast("Email tidak boleh kosong")
            return
        }

        if(password.isBlank()) {
            showShortToast("Password tidak boleh kosong")
            return
        }

        viewModel.signUp(email, password)
    }
}