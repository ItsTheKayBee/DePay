package com.example.depay;

public class History {
    private String with;
    private double amount;
    private String timestamp;
    private String currency;
    private String status;

    public History() {
    }

    public History(double amount, String currency, String status, String timestamp, String with) {
        this.with = with;
        this.amount = amount;
        this.timestamp = timestamp;
        this.currency = currency;
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    public String getWith() {
        return with;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }
}