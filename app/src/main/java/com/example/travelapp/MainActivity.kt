package com.example.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Immutable
import androidx.fragment.app.Fragment
import com.example.travelapp.ui.theme.TravelAppTheme
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val exploreFragment=ExploreFragment()
        val findMyGuideFragment=FindMyGuideFragment()
        val accountFragment=AccountFragment()

        changeFragmentTo(exploreFragment)

        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.miAccount -> changeFragmentTo(accountFragment)
                R.id.miExplore ->changeFragmentTo(exploreFragment)
                R.id.miFindMyGuide ->changeFragmentTo(findMyGuideFragment)

            }
            true
        }

    }

    private fun changeFragmentTo(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFrameLayout, fragment)
            commit()
        }
}
