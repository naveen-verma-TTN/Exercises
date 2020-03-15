/**
 * 1. Create an application which is having button start on click it will start Asynctask and
 * will download an image from internet and will show image on imageview.
 * If user goes back from page it should cancel the download (If download is in the middle).
 * During an application running, If internet connect or disconnect,
 * It should pause the download or resume the download and show toast message of connectivity status.
 * 2. Create one more button on same page which will do same task (download image) but with help of Service not with Asynctask.
 * 3. Show the download progress in a progress bar.
 */
package com.example.threadasynctaskbroadcastservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MyDownload myDownload;
    private ThreadControl tControl;
    private Boolean isDownloading = false;
    private final String url = "https://www.hdwallpapers.in/download/sunset_beach_seascape_4k_8k-7680x4320.jpg";
    private ImageView image;
    private Button pause, resume, cancel;
    private FrameLayout progressFrame;
    private ProgressBar progressBar;
    private TextView progressText;


    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        image = findViewById(R.id.image);
        resume = findViewById(R.id.resume);
        pause = findViewById(R.id.pause);
        cancel = findViewById(R.id.cancel);
        progressFrame = findViewById(R.id.progressFrame);
        progressBar = findViewById(R.id.progress);
        progressText = findViewById(R.id.progressText);
    }

    /**
     * To start the Download using AsyncTask
     */

    public void asyncDownload(View view) {
        if (isWriteStoragePermissionGranted(100)) {
            tControl = new ThreadControl();
            toggleButton("downloading");
            myDownload = new MyDownload();
            myDownload.execute(url);
        }
    }


    /**
     * AsyncTask to download image
     */


    private class MyDownload extends AsyncTask<String, Integer, Void> {
        private boolean isCompleted = false;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            image.setImageBitmap(null);
            progressBar.setProgress(0);
            progressText.setText("");
            progressBar.setMax(100);
        }

        @Override
        protected Void doInBackground(String... link) {
            isDownloading = true;
            int count;
            try {
                String root = Environment.getExternalStorageDirectory().toString();

                System.out.println("Downloading");
                URL url = new URL(link[0]);

                URLConnection connection = url.openConnection();
                connection.connect();

                int lenghtOfFile = connection.getContentLength();

                InputStream input = new BufferedInputStream(url.openStream(), 8192);


                OutputStream output = new FileOutputStream(root + "/myImage.jpg");
                byte data[] = new byte[1024];

                long total = 0;
               /* while (true) {
                    if (!isNetworkAvailable()) {
                        toggleButton("pause");
                        tControl.pause();
                    }
                    else
                        tControl.resume();*/
                while ((count = input.read(data)) != -1 && isNetworkAvailable()) {

                    publishProgress((int) (total * 100 / lenghtOfFile));

                    total += count;

                    tControl.waitIfPaused();

                    if (tControl.isCancelled()) {
                        isCompleted = false;
                        isDownloading = false;
                        break;
                    }

                    output.write(data, 0, count);

                }
                if (total != 0 && total == lenghtOfFile) {
                    isCompleted = true;
                    isDownloading = false;
//                        break;
                }
//                }

                output.flush();

                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", Objects.requireNonNull(e.getMessage()));
                isCompleted = false;
                isDownloading = false;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressText.setText(String.valueOf(values[0]));
            progressBar.setProgress(values[0]);
        }

        /**
         * Check the network state
         */
        private boolean isNetworkAvailable() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = null;
            if (connectivityManager != null) {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            }
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }


        @Override
        protected void onPostExecute(Void result) {
            File imgFile = new File(Environment.getExternalStorageDirectory().toString() + "/myImage.jpg");

            isDownloading = false;
            if (imgFile.exists() && isCompleted) {
                toggleButton("finished");
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                image.setImageBitmap(myBitmap);

            }
        }

    }

    /**
     * toggle the button views according to the user operations take place
     */

    public void toggleButton(String c) {
        switch (c) {
            case "downloading":
                progressFrame.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                resume.setVisibility(View.VISIBLE);
                pause.setEnabled(true);
                pause.setTextColor(Color.BLACK);
                resume.setEnabled(false);
                resume.setTextColor(Color.GRAY);
                cancel.setVisibility(View.VISIBLE);
                break;
            case "pause":
                pause.setEnabled(false);
                pause.setTextColor(Color.GRAY);
                resume.setEnabled(true);
                resume.setTextColor(Color.BLACK);
                break;
            case "resume":
                pause.setEnabled(true);
                pause.setTextColor(Color.BLACK);
                resume.setEnabled(false);
                resume.setTextColor(Color.GRAY);
                break;
            case "finished":
                progressFrame.setVisibility(View.GONE);
                pause.setVisibility(View.INVISIBLE);
                resume.setVisibility(View.INVISIBLE);
                cancel.setVisibility(View.INVISIBLE);
                break;
        }
    }


    /**
     * To cancel the download
     */

    public void Cancel(View view) {
        if (isDownloading) {
            toggleButton("finished");
            tControl.cancel();
        }
    }

    /**
     * To pause the download
     */

    public void Pause(View view) {
        if (isDownloading) {
            Toast.makeText(this, "Download is Paused", Toast.LENGTH_SHORT).show();
            toggleButton("pause");
            tControl.pause();
        }
    }

    /**
     * To resume the download
     */

    public void Resume(View view) {
        if (isDownloading) {
            Toast.makeText(this, "Download is resumed", Toast.LENGTH_SHORT).show();
            toggleButton("resume");
            tControl.resume();
        }
    }

    /**
     * To handle the onBackPressed
     * so that if user tap the back key it will cancel the
     * download (if it is in middle of downloading)
     * else normally close the activity
     */

    @Override
    public void onBackPressed() {
        if (isDownloading) {
            toggleButton("finished");
            Toast.makeText(this, "Download is canceled", Toast.LENGTH_SHORT).show();
            isDownloading = false;
            tControl.cancel();
            myDownload.cancel(true);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Show the cancel toast and cancel the downloading (if downloading is not finished)
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (tControl != null && !isFinishing()) {
            Toast.makeText(this, "Download is canceled", Toast.LENGTH_SHORT).show();
            tControl.cancel();
        }
    }

    /**
     * Show the pause toast and pause the downloading (if downloading is not finished)
     */

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(receiver);

        if (tControl != null && isDownloading) {
            toggleButton("pause");
            Toast.makeText(this, "Download is paused", Toast.LENGTH_SHORT).show();
            tControl.pause();
        }
    }

    /**
     * Show the resume toast and resume the downloading (if downloading is not finished)
     */

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(receiver, new IntentFilter(
                DownloadService.NOTIFICATION));

        if (tControl != null && isDownloading) {
            toggleButton("resume");
            Toast.makeText(this, "Download is resumed", Toast.LENGTH_SHORT).show();
            tControl.resume();
        }
    }

    /**
     * BroadcastReceiver to receive the result from the DownloadService
     */

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String string = bundle.getString(DownloadService.FILEPATH);
                int resultCode = bundle.getInt(DownloadService.RESULT);
                if (resultCode == RESULT_OK) {
                    Toast.makeText(MainActivity.this,
                            "Download complete. Download URI: " + string,
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Download done: " + string);
                    File imgFile = new File(string);

                    isDownloading = false;
                    if (imgFile.exists()) {
                        //toggleButton("finished");
                        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                        image.setImageBitmap(myBitmap);

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Download failed",
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Download failed");
                }
            }
        }
    };


    /**
     * To start the DownloadService
     */

    public void setDownload(View view) {
        if (isWriteStoragePermissionGranted(101)) {
            Intent intent = new Intent(this, DownloadService.class);
            intent.putExtra(DownloadService.FILENAME, "myImage.jpg");
            intent.putExtra(DownloadService.URL,
                    "https://www.hdwallpapers.in/download/sunset_beach_seascape_4k_8k-7680x4320.jpg");
            startService(intent);
        }
    }

    /**
     * check for permissions
     */


    public boolean isWriteStoragePermissionGranted(int requestCode) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
                return false;
            }
        } else {
            return true;
        }
    }


    /**
     * ask for permissions
     */


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tControl = new ThreadControl();
                    toggleButton("downloading");
                    myDownload = new MyDownload();
                    myDownload.execute(url);
                } else {
                    Log.v(TAG, "Permission Denied");
                }
                break;

            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(this, DownloadService.class);
                    intent.putExtra(DownloadService.FILENAME, "myImage.jpg");
                    intent.putExtra(DownloadService.URL,
                            url);
                    startService(intent);
                } else {
                    Log.v(TAG, "Permission Denied");
                }
                break;
        }
    }
}


