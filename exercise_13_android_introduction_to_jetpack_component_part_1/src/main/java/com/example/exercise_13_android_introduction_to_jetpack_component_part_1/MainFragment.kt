package com.example.exercise_13_android_introduction_to_jetpack_component_part_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), View.OnClickListener {

    // Navigation Controller
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        question_1_btn.setOnClickListener(this)
        question_2_btn.setOnClickListener(this)
    }

    /**
     * ClickListener to navigate from mainFragment to dataBindingFragment and viewModelFragment
     */
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.question_1_btn -> navController
                .navigate(R.id.action_mainFragment_to_dataBindingExample2)
            R.id.question_2_btn -> navController
                .navigate(R.id.action_mainFragment_to_viewModelExample)
        }
    }

}
