package com.example.activityandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editText_username;
    EditText editText_Phoneno;
    EditText editText_email;
    EditText editText_password;
    Button signup;
    Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_username = findViewById(R.id.username);
        editText_email = findViewById(R.id.email);
        editText_Phoneno = findViewById(R.id.phone);
        editText_password = findViewById(R.id.password);

        signup = findViewById(R.id.signup_btn);
        cancel = findViewById(R.id.cancel_btn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void validate() {
        if (editText_username.length() == 0) {
            editText_username.setError(getString(R.string.msg_1));
        } else if (editText_email.length() == 0) {
            editText_email.setError(getString(R.string.msg_2));
        } else if (editText_Phoneno.length() == 0) {
            editText_Phoneno.setError(getString(R.string.msg_3));
        } else if (editText_Phoneno.length() != 10) {
            editText_Phoneno.setError(getString(R.string.msg_7));
        } else if (editText_password.length() == 0) {
            editText_password.setError(getString(R.string.msg_4));
        } else if (!validEmail(editText_email.getText().toString())) {
            editText_email.setError(getString(R.string.msg_5));
        } else {
            signup();
        }
    }

    private void signup() {
        Intent intent = new Intent(this, secondPage.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", editText_username.getText().toString());
        bundle.putString("email", editText_email.getText().toString());
        bundle.putString("phone", editText_Phoneno.getText().toString());
        bundle.putString("password", editText_password.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}
