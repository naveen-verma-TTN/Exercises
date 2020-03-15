package com.example.threadasynctaskbroadcastservices;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class DownloadService extends IntentService {

    private int result = Activity.RESULT_OK;
    public static final String FILEPATH = Environment.getExternalStorageDirectory().toString();
    public static final String RESULT = "result";
    public static final String NOTIFICATION = "com.example.threadasynctaskbroadcastservices";
    public static final String URL = "urlpath";
    public static final String FILENAME = "filename";
    private NotificationManager notificationManager;
    private static String CHANNEL_ID = "CHANNEL_1";

    public DownloadService() {
        super("DownloadService");
    }

    /**
     * Download the image using the URL and saved to Internal storage
     */

    @Override
    protected void onHandleIntent(Intent intent) {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String urlPath = intent.getStringExtra(URL);
        String fileName = intent.getStringExtra(FILENAME);
        int lenghtOfFile = 0;
        int total = 0;
        int count;
        String root = Environment.getExternalStorageDirectory().toString();
        try {
            System.out.println("Downloading");
            java.net.URL url = new URL(urlPath);
            root = Environment.getExternalStorageDirectory().toString();

            URLConnection conection = url.openConnection();
            conection.connect();

            lenghtOfFile = conection.getContentLength();

            InputStream input = new BufferedInputStream(url.openStream(), 8192);


            OutputStream output = new FileOutputStream(root + "/" + fileName);
            byte[] data = new byte[1024];

            // Create notification with title and message

            CreateNotification("Downloading..", urlPath);

            while ((count = input.read(data)) != -1) {

                int progress = (int) (total * 100 / lenghtOfFile);

                // Publish notification update with title, message and progress
                updateNotification("Downloading..", urlPath, progress);

                total += count;

                output.write(data, 0, count);

            }

            output.flush();

            output.close();
            input.close();

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            notificationManager.cancel(100);
            publishResults((urlPath + "/" + fileName), Activity.RESULT_CANCELED);
        }
        notificationManager.cancel(100);
        publishResults(root + "/" + fileName, result);
    }

    public void updateNotification(String title, String message, int progress) {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder(title, message);
        notifyBuilder.setProgress(100, progress, false);
        if (notifyBuilder != null) {
            notificationManager.notify(100, notifyBuilder.build());
        }

    }

    private void publishResults(String outputPath, int result) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILEPATH, outputPath);
        intent.putExtra(RESULT, result);
        sendBroadcast(intent);
    }

    /**
     * Create notification
     */


    private void CreateNotification(String title, String message) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    "MY_NOTIFICATION_CHANNEL", NotificationManager.IMPORTANCE_LOW);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription(message);

            notificationManager.createNotificationChannel(notificationChannel);
            NotificationCompat.Builder notificationBuilder = getNotificationBuilder(title, message);
            notificationManager.notify(100, notificationBuilder.build());
        }
    }

    /**
     * Getting the notification Builder with title and message
     */

    private NotificationCompat.Builder getNotificationBuilder(String title, String body) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setOngoing(true)
                    .setSmallIcon(android.R.drawable.stat_sys_download);
        }
        return null;
    }
}