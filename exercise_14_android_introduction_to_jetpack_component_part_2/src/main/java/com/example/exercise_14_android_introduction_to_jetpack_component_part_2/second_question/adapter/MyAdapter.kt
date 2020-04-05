package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.R
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.interfaces.OnClickListenerColorChange
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model.ColorList
import kotlinx.android.synthetic.main.color_layout.view.*
import java.util.*

/**
 * RecyclerView Adapter
 */
class MyAdapter internal constructor(private val listener: OnClickListenerColorChange) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var colors: List<ColorList?> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.color_layout, parent, false)
        return MyViewHolder(
            myView
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.dataBind(colors[position], listener)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    fun setList(colors: List<ColorList?>) {
        this.colors = colors
    }

    /**
     * ViewHolder Class
     */
    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun dataBind(color: ColorList?, listener: OnClickListenerColorChange) {
            itemView.color_text.text = color!!.name.toUpperCase()
            itemView.color_layout.setBackgroundColor(Color.parseColor(color.code))
            itemView.color_layout.setOnClickListener { listener.onItemClick(color) }
        }
    }
}