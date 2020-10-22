package com.example.depay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

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

        AutoCompleteTextView currencyDropDown = findViewById(R.id.currency_dropdown);
        currencyDropDown.setAdapter(adapter);

        ArrayAdapter<CharSequence> walletAdapter = ArrayAdapter.createFromResource(this, R.array.wallet_array, R.layout.spinner_res);

        AutoCompleteTextView walletDropdown = findViewById(R.id.wallet_dropdown);
        walletDropdown.setAdapter(walletAdapter);

        Button paymentConfirmButton = findViewById(R.id.payment_confirm_button);
        paymentConfirmButton.setOnClickListener(view -> {
            //process payment
            EditText payAmountEditText = findViewById(R.id.pay_amount);
            String payAmount = payAmountEditText.getText().toString();
            String currency = currencyDropDown.getText().toString();
            String wallet = walletDropdown.getText().toString();
            Log.v("print", payAmount + " " + currency + " " + wallet);

            Web3j web3 = Web3j.build(new HttpService("http://192.168.1.105:8545"));
            try {
                Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();
                if (!clientVersion.hasError()) {
                    //Connected
                    Log.v("success", "success");
                } else {
                    //Show Error
                    Log.v("error", "error");
                }
            } catch (Exception e) {
                //Show Error
                Log.v("error", e.getMessage());
            }
        });
    }
}