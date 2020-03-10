package com.example.fileexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileExplorer extends AppCompatActivity implements onClickHandler {
    private static final String TAG = "MainActivity";

    private String root;
    private String currentPath;
    private RecyclerView recyclerView;
    private ArrayList<String> item;
    private ArrayList<String> path;
    private ArrayList<String> files;
    private File file;
    private ArrayList<String> filesPath;
    private File[] filesArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = getDirPath();

        Log.d(TAG, "------------------" + root);

        recyclerView = findViewById(R.id.list);
        if (isReadStoragePermissionGranted() && isWriteStoragePermissionGranted()) {
            getDirFromRoot(root);
        }
    }

    /**
     * getting storage-root directory path
     */

    private String getDirPath() {
        List<String> storages = new ArrayList<>();
        try {
            File[] externalStorageFiles = ContextCompat.getExternalFilesDirs(this, null);
            String base = String.format("/Android/data/%s/files", getPackageName());

            for (File file : externalStorageFiles) {
                try {
                    if (file != null) {
                        String path = file.getAbsolutePath();

                        if (path.contains(base)) {
                            String finalPath = path.replace(base, "");
                            storages.add(finalPath);
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Exception");
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception");
        }

        if (storages.size() > 1) {
            return storages.get(0);
        } else {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }

    /**
     * back button handler
     */

    @Override
    public void onBackPressed() {
        if (currentPath == null || currentPath.equals(root)) {
            super.onBackPressed();
        } else {
            getDirFromRoot(file.getParent());
        }
    }


    /**
     * getting the list of files and directory and sort them
     */

    public void getDirFromRoot(String rootPath) {

        currentPath = rootPath.toString();
        item = new ArrayList<String>();
        Boolean isRoot = true;
        path = new ArrayList<String>();
        files = new ArrayList<String>();
        filesPath = new ArrayList<String>();
        file = new File(rootPath);
        filesArray = file.listFiles();
        if (!rootPath.equals(root)) {
            item.add("../");
            path.add(file.getParent());
            isRoot = false;
        }

        if (filesArray != null)
            sortDirFiles();

        item.addAll(files);
        path.addAll(filesPath);

        initRecyclerView();
    }

    /**
     * setting up the recycler view
     */

    void initRecyclerView() {
        Recycler_Adapter recycler_adapter = new Recycler_Adapter(this, item, path);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycler_adapter);
    }

    /**
     * sorting the files and directory
     */

    void sortDirFiles() {
        Arrays.sort(filesArray);
        for (File file : filesArray) {
            if (file.isDirectory()) {
                item.add(file.getName());
                path.add(file.getPath());
            } else {
                files.add(file.getName());
                filesPath.add(file.getPath());
            }
        }
    }


    /**
     * Item click Handler for files and folder
     */

    @Override
    public void onItemClickListener(int position) {
        File isFile = new File(path.get(position));
        if (isFile.isDirectory()) {
            getDirFromRoot(isFile.toString());
        } else {
            openFile(isFile);
        }
    }

    /**
     * files type to open using intent
     */

    private void openFile(File url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(FileProvider.getUriForFile(this, getPackageName() + ".provider", file) + "/" + url.getName());
        if (url.toString().contains(".doc") || url.toString().contains(".docx")) {
            intent.setDataAndType(uri, "application/msword");
        } else if (url.toString().contains(".pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        } else if (url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
            intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        } else if (url.toString().contains(".xls") || url.toString().contains(".xlsx")) {
            intent.setDataAndType(uri, "application/vnd.ms-excel");
        } else if (url.toString().contains(".zip") || url.toString().contains(".rar")) {
            intent.setDataAndType(uri, "application/x-wav");
        } else if (url.toString().contains(".rtf")) {
            intent.setDataAndType(uri, "application/rtf");
        } else if (url.toString().contains(".wav") || url.toString().contains(".mp3")) {
            intent.setDataAndType(uri, "audio/x-wav");
        } else if (url.toString().contains(".gif")) {
            intent.setDataAndType(uri, "image/gif");
        } else if (url.toString().contains(".jpg") || url.toString().contains(".jpeg") || url.toString().contains(".png")) {
            intent.setDataAndType(uri, "image/jpeg");
        } else if (url.toString().contains(".txt") || url.toString().contains(".xml")) {
            Log.e("dfd", "here");
            intent.setDataAndType(uri, "text/plain");
        } else if (url.toString().contains(".3gp") || url.toString().contains(".mpg") || url.toString().contains(".mpeg") || url.toString().contains(".mpe") || url.toString().contains(".mp4") || url.toString().contains(".avi")) {
            intent.setDataAndType(uri, "video/*");
        } else {
            intent.setDataAndType(uri, "*/*");
        }
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }

    /**
     * check for permissions
     */

    public boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted1");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked1");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted1");
            return true;
        }
    }

    public boolean isWriteStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted2");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked2");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted2");
            return true;
        }
    }

    /**
     * ask for permissions
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 2:
                Log.d(TAG, "External storage2");
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
                    getDirFromRoot(root);
                } else {
                    Log.v(TAG, "Permission Denied");
                }
                break;

            case 3:
                Log.d(TAG, "External storage1");
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
                    getDirFromRoot(root);
                } else {
                    Log.v(TAG, "Permission Denied");
                }
                break;
        }
    }
}
