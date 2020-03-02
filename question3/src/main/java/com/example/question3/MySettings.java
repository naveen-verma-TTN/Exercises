package com.example.question3;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class MySettings extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }
}
