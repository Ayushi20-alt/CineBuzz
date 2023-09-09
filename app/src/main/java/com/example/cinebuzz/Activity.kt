package com.example.cinebuzz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.cinebuzz.Drawerfrag.Aboutusfrag
import com.example.cinebuzz.Drawerfrag.Privacypolicyfrag
import com.example.cinebuzz.Homefragments.homefrag
import com.example.cinebuzz.playerFrag.playerfrag
import com.example.cinebuzz.profilefragParts.profilefrag
import com.example.cinebuzz.search.searchfrag
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class Activity : AppCompatActivity() {
    // hamburger sign that will open the drawer
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout : DrawerLayout
    lateinit var bottomNavigationView : BottomNavigationView

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)
        

        replacefrag(homefrag())
        drawerLayout = findViewById(R.id.drawerLayout)
        var navView: NavigationView = findViewById(R.id.navigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
                R.id.AboutUs -> replacefrag2(Aboutusfrag(), it.title.toString())

                R.id.Privacy -> replacefrag2(Privacypolicyfrag(), it.title.toString())

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
       bottomNavigationView = findViewById(R.id.bottomNavigationView)
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

    private fun replacefrag2(fragment : Fragment, title : String)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        bottomNavigationView.isVisible = false
        setTitle(title)
    }
}