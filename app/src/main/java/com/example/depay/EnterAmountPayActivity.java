package com.example.depay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EnterAmountPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_amount_pay);

        Intent intent = getIntent();
        String toUser = intent.getStringExtra("to");
        TextView toUserTV = findViewById(R.id.to_user_tv);
        toUserTV.setText("To " + toUser);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency_array, R.layout.spinner_res);

        AutoCompleteTextView editTextFilledExposedDropdown = findViewById(R.id.currency_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);

        ArrayAdapter<CharSequence> walletAdapter = ArrayAdapter.createFromResource(this, R.array.wallet_array, R.layout.spinner_res);

        AutoCompleteTextView walletDropdown = findViewById(R.id.wallet_dropdown);
        walletDropdown.setAdapter(walletAdapter);

        Button paymentConfirmButton = findViewById(R.id.payment_confirm_button);
        paymentConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //process payment
            }
        });
    }
}