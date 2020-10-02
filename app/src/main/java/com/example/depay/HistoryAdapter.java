package com.example.depay;

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
        String amountReceived = history.get(position).getAmountReceived();
        String receivedFrom = history.get(position).getReceivedFrom();
        String dateOfTransaction = history.get(position).getDateOfTransaction();
        holder.receivedFrom.setText(receivedFrom);
        holder.dateOfTransaction.setText(dateOfTransaction);
        holder.amountReceived.setText(amountReceived);
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView receivedFrom, amountReceived, dateOfTransaction;

        public ViewHolder(@NonNull View view) {
            super(view);
            amountReceived = view.findViewById(R.id.money_history_text_view);
            dateOfTransaction = view.findViewById(R.id.date_history);
            receivedFrom = view.findViewById(R.id.user_receive_history_text_view);
        }
    }
}
