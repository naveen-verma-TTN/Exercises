package com.example.notificationstylingandpushnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class notificationService extends FirebaseMessagingService {
    private static final String TAG = "FirebaseMessagingToken";
    private static int REQUEST_CODE = 1;

    @Override
    public void onNewToken(@NonNull String s) {
        Log.e(TAG,s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Log.e(TAG,"here");
        Map<String, String> data = remoteMessage.getData();
        sendNotification(data);
  }




    private void sendNotification(Map<String,String> data) {
        Intent intent = new Intent(this, ItemActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url",data.get("url"));
        bundle.putString("price",data.get("price"));
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(data.get("title"))
                        .setContentText(data.get("body"))
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        try {
            URL url = new URL(data.get("url"));
            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            notificationBuilder.setStyle(new NotificationCompat.BigPictureStyle()
                    .bigPicture(image)
                    .setBigContentTitle("Notification Updated!"));
        } catch(IOException e) {
            Log.e(TAG, e.toString());
        }


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    data.get("title"),
                    NotificationManager.IMPORTANCE_DEFAULT);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        if (notificationManager != null) {
            notificationManager.notify(Integer.parseInt(getString(R.string.default_notification_channel_id)),
                    notificationBuilder.build());
        }
    }


    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }
}
