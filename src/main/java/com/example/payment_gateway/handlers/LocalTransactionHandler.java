package com.example.payment_gateway.handlers;

import com.example.payment_gateway.models.TransactionRequest;

public class LocalTransactionHandler extends TransactionHandler {
    @Override
    public void process(TransactionRequest request) {
        if (!request.isOverseas()) {
            // No fee for local transactions
            System.out.println("Local transaction processed with no fee.");
        }
    }
}
