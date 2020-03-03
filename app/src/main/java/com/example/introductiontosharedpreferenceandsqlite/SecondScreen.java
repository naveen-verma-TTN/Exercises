package com.example.introductiontosharedpreferenceandsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    TextView info;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        String username = getIntent().getExtras().getString("username","user");
        info = findViewById(R.id.info);
        info.setText("User Name: " + username);
    }


    public void logout(View view){
        sharedPreferences = getSharedPreferences("MYPREFERENCES", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        finish();
    }
}
