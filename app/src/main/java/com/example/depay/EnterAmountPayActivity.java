package com.example.depay;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

public class EnterAmountPayActivity extends AppCompatActivity {

    Web3Util web3Util = new Web3Util();

    @RequiresApi(api = Build.VERSION_CODES.N)
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

            Payment_sol_Payment paymentContract = web3Util.loadContract();
            try {
//                CompletableFuture<TransactionReceipt> transactionReceipt = paymentContract.addCrypto(new BigInteger("100")).sendAsync();
//                Log.v("dejavu", transactionReceipt.get() + "");
                CompletableFuture<BigInteger> balance = paymentContract.balanceOf().sendAsync();
                Log.v("dejavu", balance.get() + "");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}