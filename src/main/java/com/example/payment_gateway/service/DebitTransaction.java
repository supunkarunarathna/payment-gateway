package com.example.payment_gateway.service;

import com.example.payment_gateway.handlers.LocalTransactionHandler;
import com.example.payment_gateway.handlers.OverseasTransactionHandler;
import com.example.payment_gateway.handlers.TransactionHandler;
import com.example.payment_gateway.interfaces.TransactionService;
import com.example.payment_gateway.models.TransactionRequest;
import com.example.payment_gateway.models.TransactionResponse;

public class DebitTransaction implements TransactionService {

//    private final TransactionHandler handlerChain;

    private final LocalTransactionHandler localHandler;

    public DebitTransaction() {
        // Create chain of responsibility
        this.localHandler = new LocalTransactionHandler();
        OverseasTransactionHandler overseasHandler = new OverseasTransactionHandler();

        // Set up the chain
        localHandler.setNextHandler(overseasHandler);
    }

    @Override
    public TransactionResponse processTransaction(TransactionRequest request) {
        try {
            // Start the chain of handlers
            localHandler.handle(request);
            return new TransactionResponse(200, "Debit transaction processed successfully.");
        } catch (IllegalArgumentException e) {
            return new TransactionResponse(400, "Error processing debit transaction: " + e.getMessage());
        }
    }
}

