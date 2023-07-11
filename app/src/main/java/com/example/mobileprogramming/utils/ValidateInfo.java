package com.example.mobileprogramming.utils;

import android.util.Patterns;
import android.widget.EditText;

public class ValidateInfo {
    public static Boolean isValid(EditText editText) {
        String val = editText.getText().toString();
        if (val.isEmpty()) {
            editText.setError("This field cannot be empty");
            return false;
        }
        return true;
    }

    public static Boolean isValidEmail(EditText editText) {
        String val = editText.getText().toString();
        if (val.isEmpty()) {
            editText.setError("This field cannot be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(val).matches()){
                editText.setError("Please enter correct email!");
                return false;
            }
        return true;
    }
}
