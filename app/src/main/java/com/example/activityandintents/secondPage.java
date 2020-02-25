package com.example.activityandintents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class secondPage extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;

    TextView info;
    EditText editText_link;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        String username = getIntent().getExtras().getString("username");
        String email = getIntent().getExtras().getString("email");
        String phone = getIntent().getExtras().getString("phone");
        String password = getIntent().getExtras().getString("password");
        info = findViewById(R.id.info);
        info.setText("User Name: " + username + "\n" +
                "Email: " + email + "\n" +
                "Phone number: " + phone + "\n" +
                "Password: " + password );

        editText_link = findViewById(R.id.link);
        findViewById(R.id.web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_link.getText().length() == 0){
                    View view = findViewById(R.id.secondPage);
                    Snackbar.make(view, getString(R.string.msg_8), Snackbar.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+ editText_link.getText()));
                    startActivity(intent);
                }
            }
        });


        findViewById(R.id.permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
                }
                else {
                    Toast.makeText(getApplicationContext(), "camera permission granted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
}
