package com.cha.prueba.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cha.prueba.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intentSplash = Intent(this, SearchActivity::class.java)
        startActivity(intentSplash)
        finish()
    }
}