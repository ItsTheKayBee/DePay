package com.example.depay;

public class Currency {
    private double bitcoin;
    private double ether;
    private double local;

    public Currency(double bitcoin, double ether, double local) {
        this.bitcoin = bitcoin;
        this.ether = ether;
        this.local = local;
    }

    public Currency() {
    }

    public double getBitcoin() {
        return bitcoin;
    }

    public double getEther() {
        return ether;
    }

    public double getLocal() {
        return local;
    }

}
