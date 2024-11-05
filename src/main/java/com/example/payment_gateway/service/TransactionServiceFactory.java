package com.example.payment_gateway.service;

import com.example.payment_gateway.interfaces.TransactionService;

public class TransactionServiceFactory {
    public static TransactionService getTransactionService(String type) {
        if ("debit".equalsIgnoreCase(type)) {
            return new DebitTransaction();
        } else if ("credit".equalsIgnoreCase(type)) {
            return new CreditTransaction();
        }
        throw new IllegalArgumentException("Invalid transaction type");
    }
}

