package com.example.masterapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val activityName = arrayOf(
        "Kotlin Exercise 4 : Login Application Using Kotlin",
        "Exercise 11 : Android Integration With Web Services",
        "Exercise 13 : Android: Introduction to JetPack Component Part 1",
        "Exercise 14 : Android: Introduction to JetPack Component Part 2"
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
                "Exercise 13 : Android: Introduction to JetPack Component Part 1" -> {
                    startActivity(packageManager.getLaunchIntentForPackage("com.example.exercise_13_android_introduction_to_jetpack_component_part_1"))
                    makeToast(
                        "Exercise 13 : Android: Introduction to JetPack Component Part 1"
                    )
                }
                "Exercise 14 : Android: Introduction to JetPack Component Part 2" -> {
                    startActivity(packageManager.getLaunchIntentForPackage("com.example.exercise_14_android_introduction_to_jetpack_component_part_2"))
                    makeToast(
                        "Exercise 14 : Android: Introduction to JetPack Component Part 2"
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
