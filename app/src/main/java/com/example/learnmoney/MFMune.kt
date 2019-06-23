package com.example.learnmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mfmune.*

class MFMune : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mfmune)

        introduction_root.setOnClickListener {
            startActivity(Intent(this@MFMune, LevelOne::class.java))
        }

        back_image.setOnClickListener {
            onBackPressed()
        }
    }
}
