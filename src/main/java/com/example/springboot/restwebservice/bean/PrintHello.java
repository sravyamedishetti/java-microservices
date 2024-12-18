package com.example.springboot.restwebservice.bean;

public class PrintHello {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PrintHello(String message) {
        this.message = message;
    }
}
