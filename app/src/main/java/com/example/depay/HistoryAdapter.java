package com.example.depay;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<History> history;

    public HistoryAdapter(ArrayList<History> history) {
        this.history = history;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Double amount = history.get(position).getAmount();
        String with = history.get(position).getWith();
        String timestamp = history.get(position).getTimestamp();
        String status = history.get(position).getStatus();
        String currency = history.get(position).getCurrency();
        String fromto = "from";
        String neg = "+";
        if (status.equals("sent")) {
            fromto = "to";
            neg = "-";
            holder.amount.setTextColor(Color.parseColor("#FF0000"));
        }
        holder.with.setText(status + " " + fromto + " " + with);
        holder.timestamp.setText(timestamp);
        holder.amount.setText(neg + amount + " " + currency);
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView with, amount, timestamp;

        public ViewHolder(@NonNull View view) {
            super(view);
            amount = view.findViewById(R.id.money_history_text_view);
            timestamp = view.findViewById(R.id.date_history);
            with = view.findViewById(R.id.user_receive_history_text_view);
        }
    }
}
