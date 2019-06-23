package com.example.learnmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Gravity
import android.widget.TextView
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_header_main.*

class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mutual_funds_root.setOnClickListener {
            startActivity(Intent(this@Home, MFMune::class.java))
        }

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.profile -> {
                    startActivity(Intent(this@Home, ProfileActivity::class.java))
                    true
                }

                else -> { true }
            }
        }

        drawer_view.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.END)
        }
    }
}
