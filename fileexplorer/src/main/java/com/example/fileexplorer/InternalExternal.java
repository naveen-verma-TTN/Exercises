package com.example.fileexplorer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class InternalExternal extends AppCompatActivity {
    private static final String TAG = "InternalExternal";

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private Bitmap photo;
    private String filepath = "MyFileStorage";
    private String fnameInternal;
    private String fnameExternal;
    private File externalDir;
    private File internalDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_external);

        this.imageView = findViewById(R.id.photo);
        ImageButton photoButton = findViewById(R.id.photoButton);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });
    }


    /**
     * Save file to internal space
     */

    public void saveInternal(View view) {
        if (photo == null) {
            Toast.makeText(this, "Click a photo first to save to internal space",
                    Toast.LENGTH_LONG).show();
        } else {
            ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
            internalDir = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);
            fnameInternal = "Image-" + n + ".png";
            File file = new File(internalDir, fnameInternal);
            Log.i(TAG, "" + file);
            if (file.exists())
                file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e("loc", fnameInternal + " is saved " + internalDir);
            Toast.makeText(this, fnameInternal + " is saved " + internalDir.getAbsolutePath(),
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Save file to external space
     */

    public void saveExternal(View view) {
        if (photo == null) {
            Toast.makeText(this, "Click a photo first to save to external space",
                    Toast.LENGTH_LONG).show();
        } else {
            String root = Environment.getExternalStorageDirectory().toString();
            externalDir = new File(root + "/" + filepath);
            externalDir.mkdirs();
            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);
            fnameExternal = "Image-" + n + ".png";
            File file = new File(externalDir, fnameExternal);
            Log.i(TAG, "" + file);
            if (file.exists())
                file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(this, fnameExternal + " is saved " + externalDir.getAbsolutePath(),
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Share the file saved in the internal space
     */

    public void shareInternal(View view) {
        if (fnameInternal == null && internalDir == null) {
            Toast.makeText(this, "First store the file in internal space.",
                    Toast.LENGTH_LONG).show();
        } else {
            String path = MediaStore.Images.Media.insertImage(getContentResolver(), photo, fnameInternal, null);
            Uri uri = Uri.parse(path);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/png");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(intent, "Share Image from Internal space"));
        }
    }

    /**
     * Share the file saved in the external space
     */

    public void shareExternal(View view) {
        if (fnameExternal == null && externalDir == null) {
            Toast.makeText(this, "First store the file in external space.",
                    Toast.LENGTH_LONG).show();
        } else {
            String path = MediaStore.Images.Media.insertImage(getContentResolver(), photo, fnameExternal, null);
            Uri uri = Uri.parse(path);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/png");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(intent, "Share Image form External space"));
        }
    }

    /**
     * Camera image capturing intent
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Camera image intent result handler
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}

