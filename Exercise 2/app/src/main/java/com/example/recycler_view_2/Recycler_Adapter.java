package com.example.recycler_view_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecyclerAdapter";
    private ArrayList<MyData> myData;
    private Context context;
    private final int view0 = 0, view1 = 1, view2 = 2;

    RecyclerAdapter(ArrayList<MyData> myData, Context context) {
        this.myData = myData;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (myData.get(position).getType() == 0) {
            return view0;
        } else if (myData.get(position).getType() == 1) {
            return view1;
        } else if (myData.get(position).getType() == 2) {
            return view2;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case view0:
                View v0 = inflater.inflate(R.layout.header, parent, false);
                viewHolder = new ViewHolder0(v0);
                break;
            case view1:
                View v1 = inflater.inflate(R.layout.view1, parent, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case view2:
                View v2 = inflater.inflate(R.layout.view2, parent, false);
                viewHolder = new ViewHolder2(v2);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case view0:
                ViewHolder0 vh0 = (ViewHolder0) holder;
                vh0.ds.setText(myData.get(position).getTitle());
                vh0.temprature.setText(context.getText(R.string.temperature));
                break;
            case view1:
                ViewHolder1 vh1 = (ViewHolder1) holder;
                Glide.with(context).load(myData.get(position).getBanner()).into(vh1.banner_image);
                vh1.title_tv.setText(myData.get(position).getTitle());
                vh1.description_tv.setText(myData.get(position).getDescription());
                vh1.time_tv.setText(myData.get(position).getTime());
                break;
            case view2:
                ViewHolder2 vh2 = (ViewHolder2) holder;
                Glide.with(context).load(myData.get(position).getBanner()).into(vh2.banner_image);
                vh2.title_tv.setText(myData.get(position).getTitle());
                vh2.description_tv.setText(myData.get(position).getDescription());
                vh2.time_tv.setText(myData.get(position).getTime());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return myData == null ? 0 : myData.size();
    }

    static class ViewHolder0 extends RecyclerView.ViewHolder {
        TextView ds;
        TextView temprature;

        ViewHolder0(@NonNull View itemView) {
            super(itemView);
            ds = itemView.findViewById(R.id.ds);
            temprature = itemView.findViewById(R.id.temprature);
        }
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView banner_image;
        TextView title_tv;
        TextView description_tv;
        TextView time_tv;

        ViewHolder1(@NonNull View itemView) {
            super(itemView);
            banner_image = itemView.findViewById(R.id.banner);
            title_tv = itemView.findViewById(R.id.title);
            description_tv = itemView.findViewById(R.id.description);
            time_tv = itemView.findViewById(R.id.time);
        }
    }

    static class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView banner_image;
        TextView title_tv;
        TextView description_tv;
        TextView time_tv;

        ViewHolder2(@NonNull View itemView) {
            super(itemView);
            banner_image = itemView.findViewById(R.id.banner);
            title_tv = itemView.findViewById(R.id.title);
            description_tv = itemView.findViewById(R.id.description);
            time_tv = itemView.findViewById(R.id.time);
        }
    }
}
