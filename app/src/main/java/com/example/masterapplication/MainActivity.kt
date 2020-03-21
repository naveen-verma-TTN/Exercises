package com.example.masterapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val activityName = arrayOf(
        "login_application_kotlin"
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
                "login_application_kotlin" -> {
                    startActivity(packageManager.getLaunchIntentForPackage("com.example.login_application_kotlin"))
                    Toast.makeText(this, "login_application_kotlin", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
