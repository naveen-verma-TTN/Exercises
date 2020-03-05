package com.example.quesion4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment_layout extends Fragment {
    private OnClickListenerCallback onClickListenerCallback;

    ListFragment_layout(OnClickListenerCallback onClickListenerCallback) {
        this.onClickListenerCallback = onClickListenerCallback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerlist_layout, container, false);
        initRecycler(view);
        return view;
    }

    /**
     * Setting up recycler view
     */

    private void initRecycler(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        final myAdapter adapter = new myAdapter(onClickListenerCallback);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

}
