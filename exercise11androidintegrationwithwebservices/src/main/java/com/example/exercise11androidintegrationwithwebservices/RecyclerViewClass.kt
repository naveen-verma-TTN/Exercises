package com.example.exercise11androidintegrationwithwebservices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycle_view_class.*

class RecyclerViewClass : AppCompatActivity() {
    companion object {
        private const val TAG = "RecyclerViewClass"
        const val  MYDATA = "MYDATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_class)

        initRecyclerView()
    }

    /**
     * function to initialize the recyclerView
     */
    private fun initRecyclerView() {

        recyclerViewID.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val item = intent.getParcelableExtra<MyData>(MYDATA)

        val adapter = MyAdapter(item!!.posts)

        recyclerViewID.adapter = adapter
    }
}
