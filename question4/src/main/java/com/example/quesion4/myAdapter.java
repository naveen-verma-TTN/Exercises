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

import com.example.quesion4.Fragments.Blue;
import com.example.quesion4.Fragments.Green;
import com.example.quesion4.Fragments.Grey;
import com.example.quesion4.Fragments.Purple;
import com.example.quesion4.Fragments.Red;
import com.example.quesion4.Fragments.Yellow;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {
    private static final String TAG = "myAdapter";
    private ArrayList<MyData> myData;
    private Context context;

    myAdapter(Context context, ArrayList<MyData> myData) {
        this.context = context;
        this.myData = myData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, parent, false);
        MyViewHolder vh = new MyViewHolder(myView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Log.i(TAG, "onBindViewHolder");
        final MyData m = myData.get(position);
        holder.textview.setText(myData.get(position).getName());
        switch (position) {
            case 0:
                holder.layout.setBackgroundColor(Color.parseColor("#b71c1c"));
                break;
            case 1:
                holder.layout.setBackgroundColor(Color.parseColor("#039BE5"));
                break;
            case 2:
                holder.layout.setBackgroundColor(Color.parseColor("#FFD54F"));
                break;
            case 3:
                holder.layout.setBackgroundColor(Color.parseColor("#2E7D32"));
                break;
            case 4:
                holder.layout.setBackgroundColor(Color.parseColor("#607D8B"));
                break;
            case 5:
                holder.layout.setBackgroundColor(Color.parseColor("#9C27B0"));
                break;
        }


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame2, new Red())
                                .commit();
                        break;
                    case 1:
                        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame2, new Blue())
                                .commit();
                        break;
                    case 2:
                        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame2, new Yellow())
                                .commit();
                        break;
                    case 3:
                        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame2, new Green())
                                .commit();
                        break;
                    case 4:
                        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame2, new Grey())
                                .commit();
                        break;
                    case 5:
                        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame2, new Purple())
                                .commit();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount");
        return myData.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        ConstraintLayout layout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG, "MyViewHolder");
            layout = itemView.findViewById(R.id.linearLayout);
            textview = itemView.findViewById(R.id.name);
        }
    }
}
