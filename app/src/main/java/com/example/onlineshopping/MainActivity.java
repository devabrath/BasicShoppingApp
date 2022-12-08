package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    TextInputLayout name_lay,email_lay,pass_lay,conf_lay;
    EditText name_reg,email_reg,pass_reg,confirmPass_reg;
    Button register;
    TextView already_ac;

    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_lay = (TextInputLayout)findViewById(R.id.textInputName);
        email_lay = (TextInputLayout)findViewById(R.id.textInputEmail);
        pass_lay = (TextInputLayout)findViewById(R.id.textInputPassword);
        conf_lay = (TextInputLayout)findViewById(R.id.textInputConfirmPassword);

        name_reg = (EditText)findViewById(R.id.editTextName);
        email_reg = (EditText)findViewById(R.id.editTextEmail);
        pass_reg = (EditText)findViewById(R.id.editTextPassword);
        confirmPass_reg = (EditText)findViewById(R.id.editTextConfirmPassword);

        register = (Button)findViewById(R.id.RegisterButton);
        already_ac = findViewById(R.id.old_user);

         inputValidation = new InputValidation(MainActivity.this);
         databaseHelper = new DatabaseHelper(MainActivity.this);
         user = new User();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputValidation.isInputEditTextFilled(name_reg,name_lay,"Enter Full Name")){
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(email_reg,email_lay,"Enter Valid Email")){
                    return;
                }
                if (!inputValidation.isInputEditTextEmail(email_reg,email_lay,"Enter Valid Email")){
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(pass_reg,pass_lay,"Enter Password")){
                    return;
                }
                if (!inputValidation.isInputEditTextMatches(pass_reg,confirmPass_reg,conf_lay,"Password Doesn't Match")){
                    return;
                }
                if (!databaseHelper.checkUser(email_reg.getText().toString().trim(),
                    pass_reg.getText().toString().trim())){
                    user.setName(name_reg.getText().toString().trim());
                    user.setEmail(email_reg.getText().toString().trim());
                    user.setPassword(pass_reg.getText().toString().trim());
                    databaseHelper.addUser(user);

                    // Toast to show success message that record saved successfully
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    // Toast to show error message that record already exists
                    Toast.makeText(MainActivity.this, "Email Already Exists", Toast.LENGTH_LONG).show();

                }
            }
        });
        already_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
            }
        });

    }

}
