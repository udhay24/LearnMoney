package com.example.learnmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_header_main.*

class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        
        var risk = findViewById<TextView>(R.id.risk)

        mutual_funds_root.setOnClickListener {
            startActivity(Intent(this@Home, MFMune::class.java))
        }
    }
}
