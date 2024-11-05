package com.example.payment_gateway.service;

import com.example.payment_gateway.entity.Transaction;
import com.example.payment_gateway.handlers.LocalTransactionHandler;
import com.example.payment_gateway.handlers.OverseasTransactionHandler;
import com.example.payment_gateway.interfaces.TransactionService;
import com.example.payment_gateway.models.TransactionRequest;
import com.example.payment_gateway.models.TransactionResponse;
import com.example.payment_gateway.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditTransaction implements TransactionService {
    private final LocalTransactionHandler localHandler;

    @Autowired
    private TransactionRepository transactionRepository;

    public CreditTransaction() {
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

            //save transaction
            Transaction transaction = new Transaction();
            transaction.setAmount(request.getAmount());
            transaction.setName(request.getName());

            TransactionResponse.Builder builder = new TransactionResponse.Builder();
            return builder.statusCode(200).message("Credit transaction processed successfully." + "Credit amount: " + transactionRepository.save(transaction).getAmount()).build();
        } catch (IllegalArgumentException e) {
            TransactionResponse.Builder builder = new TransactionResponse.Builder();
            return builder.statusCode(400).message("Error processing credit transaction: " + e.getMessage()).build();
        }
    }
}


