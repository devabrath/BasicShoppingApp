package com.example.onlineshopping;

import android.content.Context;
import android.app.Activity;
import android.widget.EditText;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class InputValidation {
    private Context context;
    public InputValidation(Context context)
    {
        this.context = context;
    }

    public Boolean isInputEditTextFilled(EditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            textInputLayout.setError(message);
        return false;
        } else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public Boolean isInputEditTextEmail(EditText textInputEditText,TextInputLayout textInputLayout,String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            textInputLayout.setError(message);
            return false;
        } else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextMatches(EditText textInputEditText1, EditText textInputEditText2, TextInputLayout textInputLayout,String message) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            textInputLayout.setError(message);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
            return true;



    }

}