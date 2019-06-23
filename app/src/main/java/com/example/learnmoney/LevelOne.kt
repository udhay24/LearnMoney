package com.example.learnmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_level_one.*
import org.w3c.dom.Text

class LevelOne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_one)


        var text1 = findViewById<TypeWriter>(R.id.text1)
        var button = findViewById<TextView>(R.id.continueButton)


        var page = 1

        text1.setCharacterDelay(100)

        text1.animateText("Hey, I am \nRichie.\n\nLet's learn the basics of Mutual Funds today.")


        loadButton(button)


        button.setOnClickListener {


            if(page == 1) {

                button.animate().setDuration(500).alpha(0f)
                button.visibility = View.GONE
                text1.text = ""
                text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
                text1.animateText("An investment,\nthat uses money\nfrom the investors\nto invest in stocks,\nbonds or other types of investment")
                loadButton(button)
                page++

            } else if (page == 2) {

                button.animate().setDuration(500).alpha(0f)
                button.visibility = View.GONE
                text1.text = ""
                text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                text1.animateText("Suppose you have Rs.500/- with you.\n" +
                        "And you want to invest in the shares of Reliance.\n" +
                        "But, each share of Reliance costs Rs. 1000/-\n" +
                        "How can you invest in Reliance shares now?")
                loadButton(button)
                page++


            } else if (page == 3) {

                

            }


        }

        back_image.setOnClickListener {
            onBackPressed()
        }
    }


    fun loadButton(button: TextView) {


        Handler().postDelayed({

            button.visibility = View.VISIBLE
            button.alpha = 0f
            button.animate().setDuration(500).alpha(1f)

        }, 2500)

    }

}



