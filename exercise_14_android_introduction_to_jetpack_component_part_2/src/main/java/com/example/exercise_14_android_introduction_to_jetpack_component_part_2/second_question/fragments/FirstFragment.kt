package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.R
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model.ColorViewModel
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * First Fragment class
 */
class FirstFragment : Fragment() {
    private lateinit var viewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Same instance as activity
        viewModel = ViewModelProviders.of(activity!!)
            .get(ColorViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observer to observe the color change -- will update the values
        // as it has the same scope as activity
        viewModel.getColor()!!.observe(
            requireActivity(),
            Observer { color ->
                view.fragment1_layout.setBackgroundColor(Color.parseColor(color.code))
                view.fragment1_textView.text = "First Fragment \n ${color.name}"
            })
    }
}