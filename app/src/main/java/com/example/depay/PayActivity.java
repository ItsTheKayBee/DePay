package com.example.depay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Button addrENteredButton = findViewById(R.id.addr_entered_button);
        addrENteredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToPaymentConfirmScreen = new Intent(PayActivity.this, EnterAmountPayActivity.class);
                startActivity(goToPaymentConfirmScreen);
            }
        });
    }
}