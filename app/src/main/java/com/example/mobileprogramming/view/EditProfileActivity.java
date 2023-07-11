package com.example.mobileprogramming.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.mockdata.MockData;
import com.example.mobileprogramming.model.User;

import java.util.List;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editPassword;
    Button saveButton;
    String nameUser, emailUser, passwordUser;
//    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

//        reference = FirebaseDatabase.getInstance().getReference("users");

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);

//        showData();
        Intent intent = getIntent();
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        passwordUser = intent.getStringExtra("password");

        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editPassword.setText(passwordUser);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                if (isNameChanged() || isPasswordChanged() || isEmailChanged()) {
                    // api getUser by email
                    List<User> users = MockData.users;
                    for (User u : users) {
                        if (u.getEmail().equals(emailUser)) {
                            u.setName(editName.getText().toString());
                            u.setPassword(editPassword.getText().toString());
                            u.setEmail(editEmail.getText().toString());
                        }
                    }
                    Log.i("List user: ", users.toString());
                    Log.i("List user (mock data): ", MockData.users.toString());

                    // api updateUser
                    MockData.setUsers(users);
                    Log.i("List user (mock data): ", MockData.users.toString());

                    intent.putExtra("name", editName.getText().toString());
                    intent.putExtra("email", editEmail.getText().toString());
                    intent.putExtra("password", editPassword.getText().toString());
                    startActivity(intent);
                    Toast.makeText(EditProfileActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                    Toast.makeText(EditProfileActivity.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isNameChanged() {
        if (!nameUser.equals(editName.getText().toString())) {
//            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!emailUser.equals(editEmail.getText().toString())) {
//            reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        } else {
            return false;
        }
    }


    private boolean isPasswordChanged() {
        if (!passwordUser.equals(editPassword.getText().toString())) {
//            reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        } else {
            return false;
        }
    }

//    public void showData() {
//
//        Intent intent = getIntent();
//
//        nameUser = intent.getStringExtra("name");
//        emailUser = intent.getStringExtra("email");
//        passwordUser = intent.getStringExtra("password");
//
//        editName.setText(nameUser);
//        editEmail.setText(emailUser);
//        editPassword.setText(passwordUser);
//    }
}
