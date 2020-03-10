package com.example.fileexplorer;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {
    private List<String> item;
    private List<String> path;
    private onClickHandler handler;

    Recycler_Adapter(onClickHandler handler, List<String> item, List<String> path) {
        this.handler = handler;
        this.item = item;
        this.path = path;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(handler, item, path, position);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layout;
        ImageView icon;
        TextView fileName;
        TextView date;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.item_layout);
            icon = itemView.findViewById(R.id.lr_ivFileIcon);
            fileName = itemView.findViewById(R.id.lr_tvFileName);
            date = itemView.findViewById(R.id.lr_tvdate);
        }

        void bindData(final onClickHandler handler, List<String> item, List<String> path, final int position) {
            fileName.setText(item.get(position));
            icon.setImageResource(setFileImageType(new File(path.get(position))));
            date.setText(getLastDate(path, position));

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handler.onItemClickListener(position);
                }
            });
        }


        /**
         * drawable setting according to the file type
         */

        private int setFileImageType(File file) {
            try {
                int m_lastIndex = file.getAbsolutePath().lastIndexOf(".");
                String m_filepath = file.getAbsolutePath();
                if (file.isDirectory())
                    return R.drawable.ic_folder_black_24dp;
                else {
                    if (m_lastIndex != -1 && m_filepath.substring(m_lastIndex).equalsIgnoreCase(".png")) {
                        return R.drawable.ic_image_;
                    } else if (m_lastIndex != -1 && m_filepath.substring(m_lastIndex).equalsIgnoreCase(".jpg")) {
                        return R.drawable.ic_image_;
                    } else {
                        return R.drawable.ic_insert_drive_file_black_24dp;
                    }
                }
            } catch (Exception e) {
                Log.e("Exception", Objects.requireNonNull(e.getMessage()));
                return R.mipmap.ic_launcher;
            }
        }

        /**
         * getting the timestamp for files and directory
         */

        String getLastDate(List<String> path, int pos) {
            File m_file = new File(path.get(pos));
            @SuppressLint("SimpleDateFormat") SimpleDateFormat m_dateFormat
                    = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return m_dateFormat.format(m_file.lastModified());
        }
    }
}
