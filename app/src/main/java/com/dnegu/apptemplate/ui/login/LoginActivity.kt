package com.dnegu.apptemplate.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dnegu.apptemplate.MainActivity
import com.dnegu.apptemplate.R
import com.dnegu.apptemplate.common.Success
import com.dnegu.apptemplate.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        viewModel.viewState.observe(this, { viewState ->
            when (viewState) {
                is Success -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        })

        btnLogin.setOnClickListener {
            val user = txtUsername.text.toString()
            val pass = txtPassword.text.toString()

            if(user == getString(R.string.usuarioLogin) && pass == getString(R.string.passwordLogin) || true){
                startActivity(Intent(this, MainActivity::class.java))
                //viewModel.login(user)
            }
            else
                Toast.makeText(this, getString(R.string.usuario_password_invalidos), Toast.LENGTH_SHORT).show()
        }
    }
}