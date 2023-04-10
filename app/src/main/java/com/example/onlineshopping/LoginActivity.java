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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextView forgotPass;
    EditText email,pass;
    Button login;
    TextView reg;
    TextInputLayout email_layout,pass_layout;
    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.editTextEmail);
        pass = (EditText)findViewById(R.id.editTextPassword);
        login = (Button)findViewById(R.id.LoginButton);
        reg = (TextView)findViewById(R.id.new_user);
        forgotPass = (TextView)findViewById(R.id.forgotPassword);

        email_layout = (TextInputLayout)findViewById(R.id.textInputEmail);
        pass_layout = (TextInputLayout)findViewById(R.id.textInputPassword);

        databaseHelper = new DatabaseHelper(LoginActivity.this);
        inputValidation = new InputValidation(LoginActivity.this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.stay);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputValidation.isInputEditTextFilled(email, email_layout, getString(R.string.error_message_email))) {
                    return;
                }
                if (!inputValidation.isInputEditTextEmail(email, email_layout, getString(R.string.error_message_email))) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(pass, pass_layout, getString(R.string.error_message_password))) {
                    return;
                }

                if (databaseHelper.checkUser(email.getText().toString().trim(),pass.getText().toString().trim())) {

                    Intent accountsIntent = new Intent(LoginActivity.this, Nav.class);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
                    startActivity(accountsIntent);
                }else {
                    Toast.makeText(LoginActivity.this,getString(R.string.error_valid_email_password), Toast.LENGTH_SHORT).show();
                }
            }

        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"Feature will be \n Available Soon",Toast.LENGTH_SHORT).show();
            }
        });



    }
}