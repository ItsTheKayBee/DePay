package com.example.depay;

public class History {
    private String receivedFrom;
    private String amountReceived;
    private String dateOfTransaction;

    public History(String receivedFrom, String amountReceived, String dateOfTransaction) {
        this.receivedFrom = receivedFrom;
        this.amountReceived = amountReceived;
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public String getAmountReceived() {
        return amountReceived;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }
}