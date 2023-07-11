package com.example.mobileprogramming.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.mockdata.MockData;
import com.example.mobileprogramming.model.User;
import com.example.mobileprogramming.utils.ValidateInfo;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText signupName, signupEmail, signupPassword, signupConfirmPassword;
    TextView loginRedirectText;
    Button signupButton;
//    private FirebaseAuth mAuth;
//    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Khởi tạo FirebaseAuth và DatabaseReference
//        mAuth = FirebaseAuth.getInstance();
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupConfirmPassword = findViewById(R.id.signup_confirm_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser() {
        final String name = signupName.getText().toString().trim();
        final String email = signupEmail.getText().toString().trim();
        String password = signupPassword.getText().toString().trim();
        String confirmPassword = signupConfirmPassword.getText().toString().trim();

        boolean check1 = ValidateInfo.isValid(signupName);
        boolean check2 = ValidateInfo.isValidEmail(signupEmail);
        boolean check3 = ValidateInfo.isValid(signupPassword);
        boolean check4 = ValidateInfo.isValid(signupConfirmPassword);

        // Kiểm tra xem mật khẩu và xác nhận mật khẩu có khớp nhau hay không
        boolean check5 = true;
        if (!password.equals(confirmPassword)) {
            signupConfirmPassword.setError("Mật khẩu và xác nhận mật khẩu không khớp");
            check5 = false;
        }

        if (!(check1 && check2 && check3 && check4 && check5)) {
            return;
        }
            // Tạo người dùng trên Firebase Authentication
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Lấy ID người dùng đã đăng ký
//                                String userId = mAuth.getCurrentUser().getUid();
//
//                                // Tạo một nút con với ID của người dùng trong Firebase Realtime Database
//                                DatabaseReference currentUserDb = mDatabase.child(userId);
//
//                                // Đặt các thông tin đăng ký vào nút con đó
//                                currentUserDb.child("name").setValue(name);
//                                currentUserDb.child("email").setValue(email);
////                                currentUserDb.child("password").setValue(password);
//                                // Hiển thị thông báo thành công và chuyển người dùng đến màn hình chính
//                                Toast.makeText(SignupActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
//                                // Chuyển đến màn hình đăng nhập
//                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
//                                startActivity(intent);
//                            } else {
//                                // Hiển thị lỗi nếu đăng ký không thành công
//                                Toast.makeText(SignupActivity.this, "Đăng ký thất bại: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });

        // api register
        MockData data = new MockData();
        data.addUser(new User(name, password, email));

        // Hiển thị thông báo thành công và chuyển người dùng đến màn hình chính
        Toast.makeText(SignupActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
        // Chuyển đến màn hình đăng nhập
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}