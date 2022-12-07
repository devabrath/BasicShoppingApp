package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    EditText email,pass;
    Button login;
    TextInputLayout email_layout,pass_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.editTextEmail);
        pass = (EditText)findViewById(R.id.editTextPassword);

        email_layout = (TextInputLayout)findViewById(R.id.textInputEmail);
        pass_layout = (TextInputLayout)findViewById(R.id.textInputPassword);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView reg = findViewById(R.id.new_user);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.stay);
            }
        });

        login = findViewById(R.id.LoginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(LoginActivity.this,Nav.class);
                startActivity(login);
                overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
            }
        });



    }
}