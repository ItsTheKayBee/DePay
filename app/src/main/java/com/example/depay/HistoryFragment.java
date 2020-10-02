package com.example.depay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    private static final int SCROLL_DIRECTION_UP = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        RecyclerView historyView = view.findViewById(R.id.history_recycler_view);
        historyView.setHasFixedSize(true);
        historyView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<History> histories = data();
        HistoryAdapter historyAdapter = new HistoryAdapter(histories);
        historyView.setAdapter(historyAdapter);
        return view;
    }

    ArrayList<History> data() {
        ArrayList<History> histories = new ArrayList<>();
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Nidhi", "40$", "Oct 20, 2020"));
        histories.add(new History("Sent to Hsivd", "60$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        histories.add(new History("Received from Kunal", "20$", "Oct 20, 2020"));
        return histories;
    }
}
