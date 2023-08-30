package com.example.myproject;

public class UserData {
    private String username;
    private String password;

    public UserData() {
        // Default constructor required for Firebase
    }

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Add getters and setters as needed
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
