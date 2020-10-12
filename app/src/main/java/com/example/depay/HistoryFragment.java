package com.example.depay;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class HistoryFragment extends Fragment {

    RecyclerView historyView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        historyView = view.findViewById(R.id.history_recycler_view);
        historyView.setHasFixedSize(true);
        historyView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        final ArrayList<History> histories = new ArrayList<>();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String username = sharedPreferences.getString(RegisterActivity.Username, "");

        DatabaseReference db = FirebaseDatabase.getInstance().getReference("transactions");
        db.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot transaction : dataSnapshot.getChildren()) {
                    History history = transaction.getValue(History.class);
                    histories.add(history);
                    HistoryAdapter historyAdapter = new HistoryAdapter(histories);
                    historyView.setAdapter(historyAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v("login", "Failed", error.toException());
            }
        });
    }
}
