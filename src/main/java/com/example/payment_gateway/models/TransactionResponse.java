package com.example.payment_gateway.models;

public class TransactionResponse {

    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }
    public String getMessage() {
        return message;
    }

    //Using builder design pattern
    public TransactionResponse(Builder builder){
        this.message = builder.message;
        this.statusCode = builder.statusCode;
    }

    public static class Builder{
        private String message;
        private int statusCode;

        public TransactionResponse build(){
            return new TransactionResponse(this);
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder statusCode(int statusCode){
            this.statusCode = statusCode;
            return this;
        }
    }
}
