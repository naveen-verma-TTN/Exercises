package com.example.recycler_view_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

// Exercise 2: Create a Recycler View to show some of the news by creating some dummy data from the API -
// https://newsapi.org/s/google-news-api (Just copy the data from api).
// Design should look similar to this photo (follow link), Should contain items of three types:
// 1. Text only
// 2. Text with Large banner image and
// 3. Text with small image.

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<MyData> myData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Recycler_init();
    }

    void Recycler_init(){
        dummyDATA();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerAdapter adapter = new RecyclerAdapter(myData, MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void dummyDATA() {
        myData.add(new MyData(null,"Top news briefing",null,null,0));
        myData.add(new MyData("https://www.pajiba.com/assets_c/2020/02/GettyImages-510287850-thumb-700x493-222732.jpg",getString(R.string.title),getString(R.string.desc),getString(R.string.time),1));
        myData.add(new MyData("https://www.newsbtc.com/wp-content/uploads/2020/02/shutterstock_376214587-1200x780.jpg",getString(R.string.title2),getString(R.string.desc2),getString(R.string.time2),2));
        myData.add(new MyData("https://www.newsbtc.com/wp-content/uploads/2020/02/shutterstock_376214587-1200x780.jpg",getString(R.string.title2),getString(R.string.desc2),getString(R.string.time2),2));
        myData.add(new MyData("https://www.newsbtc.com/wp-content/uploads/2020/02/shutterstock_376214587-1200x780.jpg",getString(R.string.title2),getString(R.string.desc2),getString(R.string.time2),2));
        myData.add(new MyData("https://www.newsbtc.com/wp-content/uploads/2020/02/shutterstock_376214587-1200x780.jpg",getString(R.string.title2),getString(R.string.desc2),getString(R.string.time2),2));
        myData.add(new MyData("https://www.newsbtc.com/wp-content/uploads/2020/02/shutterstock_376214587-1200x780.jpg",getString(R.string.title2),getString(R.string.desc2),getString(R.string.time2),2));
    }
}
