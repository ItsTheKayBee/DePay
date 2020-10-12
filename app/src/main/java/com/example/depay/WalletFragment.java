package com.example.depay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

public class WalletFragment extends Fragment {

    static TextView btcLocalText;
    TextView btcText;
    TextView localText;
    TextView ethText;
    double bitcoin = 0;
    double local = 0;
    double ether = 0;

    static void setBtcPrice(double localPrice) {
        btcLocalText.setText(String.valueOf(localPrice));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wallet, container, false);
        Button addMoneyButton = view.findViewById(R.id.add_bitcoin_button);
        addMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAddMoney = new Intent(getActivity(), AddMoney.class);
                startActivity(goToAddMoney);
            }
        });

        btcLocalText = view.findViewById(R.id.btc_to_local);
        btcText = view.findViewById(R.id.bitcoin_amount);
        ethText = view.findViewById(R.id.ether_amount);
        localText = view.findViewById(R.id.local_amount);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String username = sharedPreferences.getString(RegisterActivity.Username, "");

        DatabaseReference db = FirebaseDatabase.getInstance().getReference("wallets");
        db.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Currency currency = dataSnapshot.getValue(Currency.class);
                bitcoin = currency.getBitcoin();
                setBitcoin(bitcoin);
                local = currency.getLocal();
                setLocal(local);
                ether = currency.getEther();
                setEther(ether);
                new GetCurrencyData(getContext()).execute(bitcoin);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v("login", "Failed", error.toException());
            }
        });
    }

    private void setEther(double ether) {
        ethText.setText(String.valueOf(ether));
    }

    private void setBitcoin(double bitcoin) {
        btcText.setText(String.valueOf(bitcoin));

    }

    private void setLocal(double local) {
        localText.setText(String.valueOf(local));
    }

    private static class GetCurrencyData extends AsyncTask<Double, Void, Void> {
        Context context;

        public GetCurrencyData(Context context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(final Double[] btc) {
            final double[] finalPrice = {0};
            String url = "https://api.coindesk.com/v1/bpi/currentprice/INR.json";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject usd = response.getJSONObject("bpi").getJSONObject("INR");
                                double rateInLocal = Double.parseDouble(usd.getString("rate").replaceAll(",", ""));
                                finalPrice[0] = rateInLocal * btc[0];
                                setBtcPrice(finalPrice[0]);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });
            Volley.newRequestQueue(context).add(jsonObjectRequest);
            return null;
        }
    }
}
