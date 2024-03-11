package com.example.myapplication1

import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.View
import android.widget.Toast
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity()  {


    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }
      fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.access_alarm -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AlarmFragment()).commit()
            R.id.add_a_photo -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PhotoFragment()).commit()
            R.id.add_task -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TaskFragment()).commit()
            R.id.add_location -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LocationFragment()).commit()
            R.id.logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

private fun NavigationView.setNavigationItemSelectedListener(mainActivity: MainActivity) {

}
