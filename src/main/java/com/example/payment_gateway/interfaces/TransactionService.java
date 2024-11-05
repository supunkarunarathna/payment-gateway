package com.example.payment_gateway.interfaces;

import com.example.payment_gateway.models.TransactionRequest;
import com.example.payment_gateway.models.TransactionResponse;

public interface TransactionService {
    TransactionResponse processTransaction(TransactionRequest request);
}
