package com.example.recycle_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;


//Exercise 1: Create a Recycler View to show a list of names of Android Trainees.
// Add pagination to append few dummy names to this list. (Choose design of your choice).

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    ArrayList<MyData> myData = new ArrayList<MyData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dummyDATA();

        recyclerView = findViewById(R.id.recycler);
        final myAdapter adapter = new myAdapter(this, myData);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int current = 1;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (!recyclerView.canScrollVertically(1)) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= PAGE_SIZE) {
                        current++;
                        Toast.makeText(MainActivity.this, "Loading more data", Toast.LENGTH_LONG).show();
                        Log.i("sss", String.valueOf("Dummy Data"));
                        dummyDATA();
                        adapter.notifyDataSetChanged();
                    }
                }
                //isLoading = true;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void dummyDATA() {
            myData.add(new MyData("Akaanksha Gupta"));
            myData.add(new MyData("Ankit Arora"));
            myData.add(new MyData("Anupam Bhardwaj"));
            myData.add(new MyData("Ashutosh Srivastava"));
            myData.add(new MyData("Astha Singh"));
            myData.add(new MyData("Bharat TTN"));
            myData.add(new MyData("Lakshya Sharma"));
            myData.add(new MyData("Priya Patel"));
            myData.add(new MyData("Subarno Chatterjee"));
            myData.add(new MyData("Tanvi Gupta"));
            myData.add(new MyData("Ujjwal Kumar"));
    }
}
