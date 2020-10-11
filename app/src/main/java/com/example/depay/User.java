package com.example.depay;

public class User {
    public String email;
    public String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
