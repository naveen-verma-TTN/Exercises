package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.ViewModelExample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exercise_13_android_introduction_to_jetpack_component_part_1.R

/**
 * A simple [Fragment] subclass.
 */
class ViewModelExample : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_model_example, container, false)
    }

}
