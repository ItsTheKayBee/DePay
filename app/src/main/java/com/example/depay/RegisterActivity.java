package com.example.depay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    TextView loginClick;
    Button registerButton;
    public static final String Username = "username";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginClick = findViewById(R.id.login_click);
        loginClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(goToLogin);
            }
        });

        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText email = findViewById(R.id.register_email);
                TextInputEditText pwd = findViewById(R.id.register_password);
                String emailText = Objects.requireNonNull(email.getText()).toString();
                String pwdText = Objects.requireNonNull(pwd.getText()).toString();
                doRegister(emailText, pwdText);
            }
        });
    }

    private void doRegister(String emailText, String pwdText) {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("users");
        String username = emailText.substring(0, emailText.indexOf('@'));
        User user = new User(emailText, pwdText);
        db.child(username).setValue(user);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Username, username);
        editor.apply();

        Intent goToHome = new Intent(RegisterActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }
}