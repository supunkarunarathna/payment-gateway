package com.example.payment_gateway.models;

public class TransactionResponse {

    private int statusCode;
    private String message;

    public TransactionResponse(int i, String s) {
        this.setStatusCode(i);
        this.setMessage(s);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
