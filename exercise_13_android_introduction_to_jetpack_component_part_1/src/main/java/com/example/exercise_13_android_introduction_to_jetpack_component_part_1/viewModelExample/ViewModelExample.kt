package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.viewModelExample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.exercise_13_android_introduction_to_jetpack_component_part_1.R
import kotlinx.android.synthetic.main.fragment_view_model_example.view.*

/**
 * Fragment class
 */
class ViewModelExample : Fragment() {
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this)
            .get(ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_model_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observer to observe the color change
        viewModel.getColor().observe(
            requireActivity(),
            Observer { color ->
                view.layout_view_model.setBackgroundColor(Color.parseColor(color))
            })

        // ClickListener to set the color
        view.change_color.setOnClickListener {
            val randomColor = (100000..999999).random()
            viewModel.setColor("#$randomColor")
        }
    }
}