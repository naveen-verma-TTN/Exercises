package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.dataBindingExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_13_android_introduction_to_jetpack_component_part_1.R
import kotlinx.android.synthetic.main.fragment_databinding_example.*
import kotlinx.android.synthetic.main.fragment_databinding_example.view.*

/**
 * DataBinding fragment
 */

class DataBindingExample : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_databinding_example, container, false)
    }

    /**
     * Initialize the recycler View
     */
    private fun initRecyclerView(view: View){
        val fakeList = FakeList()
        view.recyclerViewID.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        val adapter = RecyclerAdapter(fakeList.person)
        recyclerViewID.adapter = adapter
    }
}
