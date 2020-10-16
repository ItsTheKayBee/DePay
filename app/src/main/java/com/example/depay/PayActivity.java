package com.example.depay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Button addressEnteredButton = findViewById(R.id.addr_entered_button);
        addressEnteredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userAddressEditText = findViewById(R.id.receiver_address_edit_text);
                String toUser = userAddressEditText.getText().toString();
                Intent goToPaymentConfirmScreen = new Intent(PayActivity.this, EnterAmountPayActivity.class);
                goToPaymentConfirmScreen.putExtra("to", toUser);
                startActivity(goToPaymentConfirmScreen);
            }
        });
    }
}