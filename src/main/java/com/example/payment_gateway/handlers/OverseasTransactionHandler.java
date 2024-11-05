package com.example.payment_gateway.handlers;

import com.example.payment_gateway.models.TransactionRequest;

public class OverseasTransactionHandler extends TransactionHandler {
    @Override
    public void process(TransactionRequest request) {
        if (request.isOverseas()) {
            if (request.getPassportNumber() != null) {
                // Apply $7 fee for overseas transactions
                double amount = request.getAmount();
                request.setAmount(amount - 7);
                System.out.println("Overseas transaction processed with a $7 fee.");
            } else {
                throw new IllegalArgumentException("Passport number is required for overseas transactions");
            }
        }
    }
}
