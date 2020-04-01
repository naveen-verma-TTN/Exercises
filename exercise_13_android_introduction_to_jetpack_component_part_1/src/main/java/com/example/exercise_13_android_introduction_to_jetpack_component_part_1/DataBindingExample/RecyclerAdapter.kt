package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.DataBindingExample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_13_android_introduction_to_jetpack_component_part_1.databinding.MylayoutBinding

/**
 * Adapter class
 */
class RecyclerAdapter internal constructor(private val myData: List<Person>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private companion object {
        private const val TAG = "myAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : MylayoutBinding = MylayoutBinding.inflate(
            layoutInflater, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myData[position])
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    /**
     * Inner ViewHolder class
     */
    class MyViewHolder(private val binding: MylayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.person = person
        }
    }
}