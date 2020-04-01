package com.example.exercise_13_android_introduction_to_jetpack_component_part_1

/**
    1. Create Application using recycler view, fragments and data binding to
        show a list of user with name, Email,Phone Number etc with Some data.

    2. Make an color changer app Using ViewModel that consists one button
        and when a user clicks the button it changes its background color from
        some random colors. On Changing Phone orientation same color should
        remain on Screen that was clicked.
 */

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
