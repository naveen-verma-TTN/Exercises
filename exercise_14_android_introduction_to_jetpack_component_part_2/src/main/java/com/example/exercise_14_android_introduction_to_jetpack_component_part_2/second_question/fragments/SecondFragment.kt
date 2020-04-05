package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.R
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model.ColorViewModel
import kotlinx.android.synthetic.main.fragment_second.view.*

/**
 * Second Fragment class
 */
class SecondFragment : Fragment() {
    companion object {
        private const val TAG: String = "SecondFragment"
    }

    private lateinit var viewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instance of Fragment
        viewModel = ViewModelProviders.of(this)
            .get(ColorViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observer to observe the color change -- will not update as the scope is different
        viewModel.getColor()!!.observe(
            requireActivity(),
            Observer { color ->
                Log.i(TAG, color.toString());
                view.fragment2_layout.setBackgroundColor(Color.parseColor(color.code))
                view.fragment2_textView.text = "Second Fragment \n ${color.name}"
            })
    }
}