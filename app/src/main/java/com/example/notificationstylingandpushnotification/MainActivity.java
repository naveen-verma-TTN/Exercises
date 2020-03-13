package com.example.notificationstylingandpushnotification;

/*
    1. Create two activities.
    2. Send Notification through FCM , clicking on which should load Item Screen
    3. Item price and image url will be sent through fcm and same will be used to display the image and price there.
    4. Also if the notification is expanded the image should be shown there.
*/


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveTaskToBack(true);
    }
}
