package com.dnegu.apptemplate.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dnegu.apptemplate.R
import com.dnegu.apptemplate.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({ init() }, 1500)
    }

    private fun init() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}