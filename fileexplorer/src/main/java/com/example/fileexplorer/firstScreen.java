package com.example.fileexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class firstScreen extends AppCompatActivity {

    /**
     * click handler for first screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        findViewById(R.id.fileExplorerOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( firstScreen.this, fileExplorer.class));
            }
        });
        findViewById(R.id.saveInPrivatePublic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( firstScreen.this, InternalExternal.class));
            }
        });
        findViewById(R.id.fileExplorerOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( firstScreen.this, fileExplorer.class));
            }
        });
    }


}
