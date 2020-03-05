package com.example.quesion4;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {
    private static final String TAG = "myAdapter";
    private OnClickListenerCallback onClickListenerCallback;

    myAdapter(OnClickListenerCallback onClickListenerCallback) {
        this.onClickListenerCallback = onClickListenerCallback;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, parent, false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.bindData(position, onClickListenerCallback);

    }

    @Override
    public int getItemCount() {
        return onClickListenerCallback.getList().size();
    }


    /**
     * ViewHolder inner-class
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        ConstraintLayout layout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.linearLayout);
            textview = itemView.findViewById(R.id.name);
        }

        void bindData(final int position, final OnClickListenerCallback onClickListenerCallback) {
            textview.setText(onClickListenerCallback.getList().get(position).getName());
            layout.setBackgroundColor(Color.parseColor(onClickListenerCallback.getList().
                    get(position).getColorCode()));
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListenerCallback.onClickCallBack(position);
                }
            });
        }
    }
}
