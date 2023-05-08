package com.example.cinebuzz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle;
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawerLayout : DrawerLayout= findViewById(R.id.drawerLayout)
        var navView : NavigationView = findViewById(R.id.navigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                  R.id.AboutUs -> Toast.makeText(applicationContext,"Clicked About Us",Toast.LENGTH_SHORT).show()
                  R.id.Privacy -> Toast.makeText(applicationContext,"Clicked Privacy Policy",Toast.LENGTH_SHORT).show()
                  R.id.Feedback -> Toast.makeText(applicationContext,"Clicked Feedback",Toast.LENGTH_SHORT).show()
                  R.id.ChangePassword -> Toast.makeText(applicationContext,"Clicked Change Password",Toast.LENGTH_SHORT).show()
                  R.id.SignOut -> Toast.makeText(applicationContext,"Clicked Sign Out",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
           return true
        }

        return super.onOptionsItemSelected(item)
    }
}