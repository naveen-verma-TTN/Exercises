//Observe Lifecycle of Fragment with activity while using Add, Replace, hide, show, remove

package com.example.question2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Myfragment myfragment1;
    Myfragment2 myfragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        myfragment1 = new Myfragment();
        myfragment2 = new Myfragment2();
    }


    public void ADD(View view) {
        if(!myfragment1.isAdded()){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment, myfragment1, "Fragment 1");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void REPLACE(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, myfragment2, "Fragment 2");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void HIDE(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(myfragment1.isAdded()){
            fragmentTransaction.hide(myfragment1);
            fragmentTransaction.commit();
        }
        else{
            fragmentTransaction.hide(myfragment2);
            fragmentTransaction.commit();
        }


    }

    public void SHOW(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(myfragment1.isAdded()){
            fragmentTransaction.show(myfragment1);
            fragmentTransaction.commit();
        }
        else{
            fragmentTransaction.show(myfragment2);
            fragmentTransaction.commit();
        }

    }

    public void REMOVE(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
