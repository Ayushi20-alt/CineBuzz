package com.example.cinebuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import com.example.cinebuzz.Authfragments.SignIn
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    companion object{
       lateinit var token: String
       lateinit var User_ID: String
    }
    private val Splash_Time_Out = 3000L;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launch {
                if(DataStore(this@SplashScreen).isLogin() )
                {
                    token = DataStore(this@SplashScreen).getUserDetails().toString()
                    User_ID = DataStore(this@SplashScreen).getUserId().toString()
                    val intent = Intent(this@SplashScreen, Activity::class.java)
                    startActivity(intent);
                }
                else{
                    val intent = Intent(this@SplashScreen, SignIn::class.java)
                    startActivity(intent);
                }
            }

            finish();
        }, Splash_Time_Out);


    }
}