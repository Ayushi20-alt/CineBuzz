package com.example.cinebuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    private val Splash_Time_Out = 3000L;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent);
            finish();
        }, Splash_Time_Out);
    }
}