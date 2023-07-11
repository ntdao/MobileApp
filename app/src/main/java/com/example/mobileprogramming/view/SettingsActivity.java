package com.example.mobileprogramming.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView textView = findViewById(R.id.settings);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

//    public SwitchPreference testPref;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        addPreferencesFromResource(R.xml.sample);
//
//        testPref = (SwitchPreference) findPreference("test"); //Preference Key
//    }
//
//    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//        if (key.equals("test")) {
//            boolean test = sharedPreferences.getBoolean("test", false);
//            //Do whatever you want here. This is an example.
//            if (test) {
//                testPref.setSummary("Enabled");
//            } else {
//                testPref.setSummary("Disabled");
//            }
//        }
//
//        @Override
//        public void onResume() {
//            super.onResume();
//
//            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
//            boolean test = preferences.getBoolean("test", false);
//
//            if (test) {
//                testPref.setSummary("Enabled");
//            } else {
//                testPref.setSummary("Disabled");
//            }
//        }
}