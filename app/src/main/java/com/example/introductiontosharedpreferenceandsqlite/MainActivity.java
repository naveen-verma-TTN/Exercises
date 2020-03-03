/*Update existing application "login(username, password, submit button)" with following features:
    1. Store username in Shared Preference on submit button click.
    2. Username input field should be prefilled with stored username when again open the application.
    3. Clear stored data on logout.
*/

package com.example.introductiontosharedpreferenceandsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    TextView usernameTextview;
    TextView passwordTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTextview = findViewById(R.id.username);
        passwordTextview = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("MYPREFERENCES", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null);
        if(username != null){
            usernameTextview.setText(username);
        }
    }


    public void login(View view) {
        if(usernameTextview.getText().toString().trim().length() == 0){
            usernameTextview.setError("Username Should not be empty!");
        }
        else if(passwordTextview.getText().toString().trim().length() == 0){
            passwordTextview.setError("Password Should not be empty!");
        }
        else {
            String username = usernameTextview.getText().toString();
            Log.e(TAG,"here");
            editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.apply();
            editor.commit();

            Intent intent = new Intent(this, SecondScreen.class);
            Bundle bundle = new Bundle();
            bundle.putString("username",username);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }

    }
}
