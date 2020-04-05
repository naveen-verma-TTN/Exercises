/**
1. Set background image of any layout. (via Glide and via HTTP URL connection)
https://image.freepik.com/free-photo/image-human-brain_99433-298.jpg

2. Create a list by parsing below url, using both Retrofit & HttpURLConnection
https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json
 */

package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.R
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.adapter.MyAdapter
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.interfaces.OnClickListenerColorChange
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model.ColorList
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model.ColorViewModel
import kotlinx.android.synthetic.main.activity_second_question_main.*


class SecondQuestionMain : AppCompatActivity(),
    OnClickListenerColorChange {
    private lateinit var viewModel: ColorViewModel
    private lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_question_main)

        viewModel = ViewModelProviders.of(this@SecondQuestionMain)
            .get(ColorViewModel::class.java)


        initRecyclerView()

        // Observer to observe the colorList change
        viewModel.colorList.observe(
            this,
            Observer { colorList ->
                adapter.setList(colorList)
                adapter.notifyDataSetChanged()
            })
    }

    /**
     * Initialize the RecyclerView
     */
    private fun initRecyclerView() {
        recyclerViewID.layoutManager = GridLayoutManager(
            this@SecondQuestionMain, 2,
            RecyclerView.VERTICAL, false
        )

        adapter =
            MyAdapter(
                this
            )

        recyclerViewID.adapter = adapter
    }

    /**
     * ClickListener callback
     */
    override fun onItemClick(color: ColorList?) {
        viewModel.setColor(color!!)
    }
}

