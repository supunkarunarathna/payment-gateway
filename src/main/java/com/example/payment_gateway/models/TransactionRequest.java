package com.example.payment_gateway.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {

    private String senderAccountNo;
    private String receiverAccountNo;
    private String name;
    private double amount;
    private boolean overseas;
    private String passportNumber; // Only for overseas transactions

}
