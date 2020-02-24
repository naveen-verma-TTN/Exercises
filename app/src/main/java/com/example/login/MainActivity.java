package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editText_email;
    EditText editText_password;
    Button login;
    Button cancel;

    ///Constant for static login
    final String email = "naveen.verma@tothenew.com";
    final String pass = "12345";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_email = findViewById(R.id.email);
        editText_password = findViewById(R.id.password);

        login = findViewById(R.id.login_btn);
        cancel = findViewById(R.id.cancel_btn);

        login.setOnClickListener(new View.OnClickListener() {
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
        if (editText_email.length() == 0) {
            editText_email.setError(getString(R.string.msg_1));
        } else if (editText_password.length() == 0) {
            editText_password.setError(getString(R.string.msg_2));
        } else if (!validEmail(editText_email.getText().toString())) {
            editText_email.setError(getString(R.string.msg_3));
        } else {
            login();
        }
    }

    private void login() {
        View view = findViewById(R.id.loginPage);
        if (editText_email.getText().toString().equalsIgnoreCase(email) &&
                editText_password.getText().toString().equals(pass)) {
            Snackbar.make(view, getString(R.string.success_mgs), Snackbar.LENGTH_LONG).show();
        } else {
            Snackbar.make(view, getString(R.string.msg_4), Snackbar.LENGTH_LONG).show();
        }
    }

    private boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}
