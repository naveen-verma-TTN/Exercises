package com.example.android_storagepart2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {
    private static final String TAG = "myAdapter";
    private ListItemClickListener listener;
    private List<Employee> employees = new ArrayList<>();

    myAdapter(ListItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, parent, false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Employee m = employees.get(position);
        holder.bindData(m, listener, position);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    void setList(List<Employee> employees) {
        this.employees = employees;
    }


    /**
     * ViewHolder nested - class
     */

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView address;
        private TextView phone;
        private ImageButton delete;
        private ImageButton update;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            phone = itemView.findViewById(R.id.phone);
            delete = itemView.findViewById(R.id.delete);
            update = itemView.findViewById(R.id.update);
        }

        /**
         * bindData to the Recycler view
         */

        @SuppressLint("SetTextI18n")
        void bindData(final Employee employee, final ListItemClickListener listener, final int position) {
            name.setText("Employee Name: " + employee.getName());
            address.setText("Employee Address: " + employee.getAddress());
            phone.setText("Employee Phone: +91-" + employee.getPhone());

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDelete(employee, position);
                }
            });
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onEdit(employee, position);
                }
            });
        }
    }
}
