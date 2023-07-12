package com.example.mobileprogramming.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.model.User;
import com.example.mobileprogramming.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView profileName, profileEmail, profilePassword;
    Button editProfile;
    String nameUser, emailUser, phoneUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profilePassword = findViewById(R.id.profilePassword);
        editProfile = findViewById(R.id.editButton);

        TextView textView = findViewById(R.id.user_profile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        Intent intent = getIntent();
        String token = intent.getStringExtra("token");
        Log.i("token", token);
        Call<User> call = ApiService.apiService.getUserProfile("Bearer " + token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    // Xử lý dữ liệu trả về
                    nameUser = user.getName();
                    emailUser = user.getEmail();
                    phoneUser = user.getPhoneNumber();

                    profileName.setText(nameUser);
                    profileEmail.setText(emailUser);
                    profilePassword.setText(phoneUser);
                } else {
                    // Xử lý khi có lỗi từ server
                    Log.e("error", "error");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Xử lý khi có lỗi kết nối
                Log.e("error", t.getMessage());
            }
        });
//        String nameUser = intent.getStringExtra("name");
//        String emailUser = intent.getStringExtra("email");
//        String passwordUser = intent.getStringExtra("password");

//        profileName.setText(nameUser);
//        profileEmail.setText(emailUser);
//        profilePassword.setText(passwordUser);

//        showAllUserData();

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                passUserData();
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                intent.putExtra("fullname", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("phone_number", phoneUser);
                startActivity(intent);
            }
        });

    }

//    public void showAllUserData(){
//        Intent intent = getIntent();
//        String nameUser = intent.getStringExtra("name");
//        String emailUser = intent.getStringExtra("email");
//        String passwordUser = intent.getStringExtra("password");
//
//        profileName.setText(nameUser);
//        profileEmail.setText(emailUser);
//        profilePassword.setText(passwordUser);
//    }

//    public void passUserData(){
//        String email = profileEmail.getText().toString().trim();

//        Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
//        intent.putExtra("name", nameFromDB);
//        intent.putExtra("email", emailFromDB);
//        intent.putExtra("username", usernameFromDB);
//        intent.putExtra("password", passwordFromDB);
//
//        startActivity(intent);

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if (snapshot.exists()){
//
//                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
//                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
//                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
//                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
//
//                    Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
//
//                    intent.putExtra("name", nameFromDB);
//                    intent.putExtra("email", emailFromDB);
//                    intent.putExtra("username", usernameFromDB);
//                    intent.putExtra("password", passwordFromDB);
//
//                    startActivity(intent);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}