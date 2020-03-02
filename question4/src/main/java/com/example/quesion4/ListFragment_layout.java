package com.example.quesion4;

import android.os.Bundle;
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
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<MyData> myData = new ArrayList<MyData>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setColorText();
        View view = inflater.inflate(R.layout.recyclerlist_layout, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        final myAdapter adapter = new myAdapter(container.getContext(), myData);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    void setColorText() {
        myData.add(new MyData("RED"));
        myData.add(new MyData("BLUE"));
        myData.add(new MyData("YELLOW"));
        myData.add(new MyData("GREEN"));
        myData.add(new MyData("GRAY"));
        myData.add(new MyData("PURPLE"));
    }
}
