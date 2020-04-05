/*
    1. Explain all notification channel priorities.
    Ans: Notification channel priorities ranging from IMPORTANCE_NONE(0) to IMPORTANCE_HIGH(4).

        User-visible importance level	    Importance (Android 8.0 and higher)	    Priority (Android 7.1 and lower)

        Urgent                              IMPORTANCE_HIGH	                        PRIORITY_HIGH
        Makes a sound and appears                                                   or PRIORITY_MAX
        as a heads-up notification

        High                                IMPORTANCE_DEFAULT                      PRIORITY_DEFAULT
        Makes a sound

        Medium                              IMPORTANCE_LOW                          PRIORITY_LOW
        No sound

        Low                                 IMPORTANCE_MIN                          PRIORITY_MIN
        No sound and does not appear
        in the status bar

    2. Create two notification channels and send notification alternatively to both the channels every minute.
        One notifications channel should come up with sound and vibration and other one should be silent.
        Comment your code properly to explain the logic applied.
 */
package com.example.performingbackgroundtasknotificationpart2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyAlarm alarm;
    private AlarmManager alarmManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }


    @Override
    protected void onStart() {
        super.onStart();
        alarm = new MyAlarm();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.performingbackgroundtasknotificationpart2.Message");
        filter.addAction("android.intent.action.BOOT_COMPLETED");
        registerReceiver(alarm, filter);
    }

    /**
     * Setting up the Alarm
     */

    public void startAlarm(View view) {
        Log.e(TAG, "___________" + "Start");
        Toast.makeText(this, "Alarm Started..", Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.setAction("com.example.performingbackgroundtasknotificationpart2.Message");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClass(this, alarm.getClass());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() +
                60 * 10, 10 * 3, pendingIntent);

    }

    /**
     * Stopping the Alarm
     */

    public void stopAlarm(View view) {
        Log.e(TAG, "___________" + "Stop");
        Toast.makeText(this, "Alarm Stopped..", Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.setAction("com.example.performingbackgroundtasknotificationpart2.Message");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClass(this, alarm.getClass());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        alarmManager.cancel(pendingIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(alarm);
    }
}
