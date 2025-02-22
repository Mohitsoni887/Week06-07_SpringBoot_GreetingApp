package com.greetingapp.model;

public class Greeting {
    //UC2
    private String message;

    public Greeting() {}  // No-args constructor for JSON deserialization

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
