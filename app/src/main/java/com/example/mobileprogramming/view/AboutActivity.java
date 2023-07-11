package com.example.mobileprogramming.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mobileprogramming.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView textView = findViewById(R.id.settings);
//        TextView textView1 = findViewById(R.id.notice_device);
//        TextView textView2 = findViewById(R.id.notice_general);
//        TextView textView3 = findViewById(R.id.notice_community);
//        TextView textView4 = findViewById(R.id.notice_libraries);
//        TextView textView5 = findViewById(R.id.info_username);
//        TextView textView6 = findViewById(R.id.info_password);
//        TextView textView7 = findViewById(R.id.info_remove_log);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}