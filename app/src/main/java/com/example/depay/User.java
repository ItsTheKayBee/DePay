package com.example.depay;

public class User {
    public String email;
    public String password;
    public String address;

    public User() {
    }

    public User(String address, String email, String password) {
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
