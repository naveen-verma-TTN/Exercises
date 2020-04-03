package com.example.exercise_14_android_introduction_to_jetpack_component_part_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.databinding.MylayoutBinding
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.model.User
import java.util.*

/**
 * RecyclerView Adapter class
 */
 class MyAdapter internal constructor(private val listener: ListItemClickListener) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var users: List<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MylayoutBinding = MylayoutBinding.inflate(
            layoutInflater, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, listener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setList(users: List<User>) {
        this.users = users
    }


    /**
     * Inner ViewHolder class
     */
    class MyViewHolder(private val binding: MylayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, clickListener: ListItemClickListener) {
            binding.user = user
            binding.imageUrl = "https://image.flaticon.com/icons/png/512/149/149074.png"
            binding.clickListener = clickListener
        }
    }
}