package com.org.litness.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.org.litness.R
import com.org.litness.databinding.ActivityLoginBinding
import com.org.litness.ui.login.viewmodel.LoginViewModel
import com.org.litness.ui.regis.RegisActivity
import com.org.litness.util.showShortToast
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

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

        binding.btnLogin.setOnClickListener {
            login()
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisActivity::class.java))
        }
    }

    private fun observer() {
        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                uiState.message?.let {
                    showShortToast(it)
                }
            }
        }
    }

    private fun login() {
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

        viewModel.login(email, password)
    }
}