package com.example.payment_gateway.handlers;

import com.example.payment_gateway.models.TransactionRequest;

public abstract class TransactionHandler {

    protected TransactionHandler next;

    public void setNextHandler(TransactionHandler next) {
        this.next = next;
    }

    public void handle(TransactionRequest request) {
        // Process the request in the current handler
        process(request);

        // Pass the request to the next handler if available
        if (next != null) {
            next.handle(request);
        }
    }

    protected abstract void process(TransactionRequest request);
}
