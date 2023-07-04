package com.example.cinebuzz

import android.annotation.SuppressLint
import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.cinebuzz.databinding.ActivityBinding
import com.example.cinebuzz.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class Activity : AppCompatActivity() {
    // hamburger sign that will open the drawer
    lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)

        replacefrag(homefrag())
        var drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        var navView: NavigationView = findViewById(R.id.navigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.AboutUs -> Toast.makeText(
                    applicationContext,
                    "Clicked About Us",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Privacy -> Toast.makeText(
                    applicationContext,
                    "Clicked Privacy Policy",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Feedback -> Toast.makeText(
                    applicationContext,
                    "Clicked Feedback",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.ChangePassword -> Toast.makeText(
                    applicationContext, "Clicked Change Password",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.SignOut -> Toast.makeText(
                    applicationContext,
                    "Clicked Sign Out",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

        // bootom navigation view code
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> replacefrag(homefrag())
                R.id.search -> replacefrag(searchfrag())
                R.id.player -> replacefrag(playerfrag())
                R.id.profile -> replacefrag(profilefrag())
                else ->{

                }
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

    // method to replace the fragments
    private fun replacefrag(fragment : Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}