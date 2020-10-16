package com.example.depay;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;

public class AccountFragment extends Fragment {

    private String email;
    private String username;
    private TextInputEditText emailEdit;
    private TextInputEditText usernameEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        ArrayAdapter<CharSequence> walletAdapter = ArrayAdapter.createFromResource(getContext(), R.array.currency_array, R.layout.spinner_res);

        AutoCompleteTextView walletDropdown = view.findViewById(R.id.default_currency_dropdown);
        walletDropdown.setAdapter(walletAdapter);
        emailEdit = view.findViewById(R.id.acc_email);
        emailEdit.setEnabled(false);
        usernameEdit = view.findViewById(R.id.acc_uname);
        usernameEdit.setEnabled(false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("users");
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        username = sharedPreferences.getString(RegisterActivity.Username, "");

        db.child(username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = dataSnapshot.getValue(User.class);
                    email = user.getEmail();
                    emailEdit.setText(email + "");
                    usernameEdit.setText(username + "");
                } else {
                    Log.e("account", "error");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v("login", "Failed to read value.", error.toException());
            }
        });
    }
}
