/**
 *  1.Create Application using recycler view, fragments and data binding to show a list
 *      of user with name, Email,Phone Number etc with Some data.
 *      Click on floating action button should show a fragment to add user
 *      details -> Clicking on save should insert in DB (use live data to get the
 *      list of users and be observed by the view).
 *
 *  2. ViewModel Scoping
 */
package com.example.exercise_14_android_introduction_to_jetpack_component_part_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.FirstQuestionMain
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question_1_btn.setOnClickListener(this)
        question_2_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.question_1_btn -> startActivity(Intent(this, FirstQuestionMain::class.java))
            R.id.question_2_btn -> startActivity(Intent(this,FirstQuestionMain::class.java))
        }
    }
}