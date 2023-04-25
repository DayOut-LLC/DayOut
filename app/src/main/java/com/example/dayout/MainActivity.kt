package com.example.dayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.widget.ImageView
import com.example.dayout.databinding.ActivityMainBinding
import kotlinx.serialization.json.Json
import android.content.Intent
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//    private val savedNutritionData = mutableListOf<NutritionData>()
//    private lateinit var recy: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        // define your fragments here
       // val mapFragment: Fragment = MapFragment()
        val eventFragment: Fragment = EventFragment()
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.nav_list -> fragment = eventFragment
              //  R.id.nav_map -> fragment = mapFragment
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.nav_list
    }

    // Helper method to replace the FrameLayout with the fragment
    private fun replaceFragment(eventFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, eventFragment)
        fragmentTransaction.commit()
    }
}

//
