package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onNewUserClick(View view)
    {
        startActivity(new Intent(this,MainActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.stay);
    }
    public void onButtonClick(View view)
    {
        startActivity(new Intent(this,Nav.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}