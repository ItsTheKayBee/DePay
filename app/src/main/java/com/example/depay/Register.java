package com.example.depay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    TextView loginClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginClick = findViewById(R.id.login_click);
        loginClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLogin = new Intent(Register.this, MainActivity.class);
                startActivity(goToLogin);
            }
        });
    }
}