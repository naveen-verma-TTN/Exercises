package com.example.exercise11androidintegrationwithwebservices

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exercise11androidintegrationwithwebservices.MyAdapter.MyViewHolder
import kotlinx.android.synthetic.main.mylayout.view.*

class MyAdapter internal constructor(private val myData: List<Posts>) :
    RecyclerView.Adapter<MyViewHolder>() {

    private companion object {
        private const val TAG = "myAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.mylayout, parent, false)
        return MyViewHolder(myView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.dataBind(myData[position])
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    /**
     * ViewHolder Class
     */
    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun dataBind(myData: Posts) {
            itemView.nameID.text = myData.name
            itemView.messageID.text = myData.message
            Glide.with(itemView.context).load(myData.profileImage)
                .into(itemView.photoID)
        }
    }
}