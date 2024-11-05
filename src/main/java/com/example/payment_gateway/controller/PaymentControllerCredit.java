package com.example.payment_gateway.controller;

import com.example.payment_gateway.interfaces.TransactionService;
import com.example.payment_gateway.models.TransactionRequest;
import com.example.payment_gateway.models.TransactionResponse;
import com.example.payment_gateway.service.TransactionServiceFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit")
public class PaymentControllerCredit {

    @PostMapping("/process")
    public ResponseEntity<TransactionResponse> handleCreditTransaction(@RequestBody TransactionRequest request) {
        TransactionService service = TransactionServiceFactory.getTransactionService("credit");
        TransactionResponse response = service.processTransaction(request);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
