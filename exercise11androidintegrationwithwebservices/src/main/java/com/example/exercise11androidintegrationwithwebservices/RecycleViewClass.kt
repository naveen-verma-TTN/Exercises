package com.example.exercise11androidintegrationwithwebservices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycle_view_class.*
import org.json.JSONObject

class RecycleViewClass : AppCompatActivity() {
    companion object {
        private const val TAG = "RecycleViewClass"
    }
    private val list = ArrayList<MyDataClass.Posts>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_class)

        initRecyclerView()
    }

    private fun initRecyclerView() {

        recyclerViewID.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val json = intent?.getStringExtra("JSON")
        jsonParse(json!!)

        val adapter = MyAdapter(list)

        recyclerViewID.adapter = adapter
    }

    private fun jsonParse(json: String) {
        val jsonObj = JSONObject(json.substring(json.indexOf("{"), json.lastIndexOf("}") + 1))
        val posts = jsonObj.getJSONArray("posts")
        for (i in 0 until posts.length()) {

            val name = posts.getJSONObject(i).getString("name")

            val message = posts.getJSONObject(i).getString("message")

            val profileImage = posts.getJSONObject(i).getString("profileImage")

            list.add(MyDataClass.Posts(name, message, profileImage))
        }
    }
}
