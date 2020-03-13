package com.example.notificationstylingandpushnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ItemActivity extends AppCompatActivity {
    private static final String TAG = "ItemActivity";

    private ImageView photo;
    private TextView priceTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        photo = findViewById(R.id.url);
        priceTV = findViewById(R.id.price);


        String url = getIntent().getExtras().getString("url");

        Log.e("here",url);

        Glide.with(this)
                .load(url.trim())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(photo);

     //   Picasso.with(this).load(url).resize(120, 60).into(photo);

        String price = getIntent().getExtras().getString("price");
        priceTV.setText("Price: " + price);

    }
}
