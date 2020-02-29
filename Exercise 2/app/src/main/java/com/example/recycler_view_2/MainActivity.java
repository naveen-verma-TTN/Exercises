package com.example.recycler_view_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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

    void Recycler_init() {
        getData();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerAdapter adapter = new RecyclerAdapter(myData, MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        myData.add(new MyData(null, "Top news briefing", null, null, 0));
        parseJson();
    }

    private void parseJson() {
        String str = getContentFromJson();
        try {
            JSONObject jObject = new JSONObject(str);
            JSONArray jArray = jObject.getJSONArray("articles");

            for (int i = 0; i < jArray.length(); i++) {
                try {
                    JSONObject oneObject = jArray.getJSONObject(i);
                    String urlToImage = oneObject.getString("urlToImage");
                    String title = oneObject.getString("title");
                    String description = oneObject.getString("description");
                    String publishedAt = oneObject.getString("publishedAt");
                    if (i == 0) {
                        myData.add(new MyData(urlToImage, title, description, publishedAt, 1));
                    } else {
                        myData.add(new MyData(urlToImage, title, description, publishedAt, 2));
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "parseJson Exception");
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "parseJson Exception: " + e.getMessage());
        }
    }

    private String getContentFromJson() {
        InputStream inputStream = this.getResources().openRawResource(R.raw.news_data);
        String temp;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder out = new StringBuilder();
        try {
            while (((temp = reader.readLine()) != null)) {
                out.append(temp);
            }
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
