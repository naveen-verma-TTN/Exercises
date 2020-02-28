package com.example.recycle_view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {
    private static final String TAG = "myAdapter";
    private ArrayList<MyData> myData;
    private Context context;

    myAdapter(Context context, ArrayList<MyData> myData){
        this.context = context;
        this.myData = myData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        /*LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        // Create a stand-alone view
        View myView = LayoutInflater.from(context)
                .inflate(R.layout.mylayout, null, false);
        linearLayout.addView(myView);*/
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, parent, false);
        MyViewHolder vh = new MyViewHolder(myView);
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder");
        final MyData m = myData.get(position);
        holder.textview.setText(myData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount");
        return myData.size();
    }


     static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textview;

         MyViewHolder(@NonNull View itemView) {
            super(itemView);
             Log.i(TAG, "MyViewHolder");
            textview = itemView.findViewById(R.id.name);
        }
    }
}
