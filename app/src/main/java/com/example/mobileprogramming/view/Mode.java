package com.example.mobileprogramming.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileprogramming.LoginRequest;
import com.example.mobileprogramming.LoginResponse;
import com.example.mobileprogramming.R;
import com.example.mobileprogramming.SwitchRequest;
import com.example.mobileprogramming.SwitchResponse;
import com.example.mobileprogramming.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode);

        Button btn = findViewById(R.id.btnOn);
        ImageView imageView = findViewById(R.id.imageLight);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = btn.getText().toString();
                if (status == "ON") {
                    btn.setText("OFF");
                    imageView.setImageResource(R.drawable.on);
                    switchStatus("ON");
                } else {
                    btn.setText("ON");
                    imageView.setImageResource(R.drawable.off);
                    switchStatus("OFF");
                }
            }

        });

        TextView textView = findViewById(R.id.control);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mode.this, ListDevice.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    private void switchStatus(String status) {
        SwitchRequest request = new SwitchRequest(status);
        Call<SwitchResponse> call = ApiService.apiService.switchLight1(request);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<SwitchResponse> call, Response<SwitchResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Mode.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    // Xử lý lỗi đăng nhập
                    Toast.makeText(Mode.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SwitchResponse> call, Throwable t) {
                // Xử lý lỗi kết nối hoặc lỗi mạng
                Toast.makeText(Mode.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}