package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.DataBindingExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise_13_android_introduction_to_jetpack_component_part_1.R

class ViewModelExample : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_model_example, container, false)
    }

}
