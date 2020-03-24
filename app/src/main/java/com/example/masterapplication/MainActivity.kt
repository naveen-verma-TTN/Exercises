package com.example.masterapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val activityName = arrayOf(
        "Kotlin Exercise 4 : Login Application Using Kotlin",
        "Exercise 11 : Android Integration With Web Services"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (spinner != null) {
            val arrayAdapter =
                ArrayAdapter(this, R.layout.spinner_text, activityName)
            spinner.adapter = arrayAdapter
        }

        gotoBT.setOnClickListener {
            when (spinner.selectedItem) {
                "Kotlin Exercise 4 : Login Application Using Kotlin" -> {
                    startActivity(packageManager.getLaunchIntentForPackage("com.example.login_application_kotlin"))
                    makeToast(
                        "login_application_kotlin"
                    )
                }
                "Exercise 11 : Android Integration With Web Services" -> {
                    startActivity(packageManager.getLaunchIntentForPackage("com.example.exercise11androidintegrationwithwebservices"))
                    makeToast(
                        "Exercise 11 : Android Integration With Web Services"
                    )
                }
            }
        }
    }


    private fun makeToast(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }
}
