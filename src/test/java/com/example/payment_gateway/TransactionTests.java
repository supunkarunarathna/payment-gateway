package com.example.payment_gateway;

import com.example.payment_gateway.controller.PaymentControllerCredit;
import com.example.payment_gateway.controller.PaymentControllerDebit;
import com.example.payment_gateway.models.TransactionRequest;
import com.example.payment_gateway.models.TransactionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransactionTests {

    @Autowired
    private PaymentControllerCredit paymentControllerCredit;

    @Autowired
    private PaymentControllerDebit paymentControllerDebit;

    @Test
    public void testDebitTransaction() {
        TransactionRequest request = new TransactionRequest();
        // Set request properties for local/overseas
        // Create and set up a mock request for a debit transaction
        request.setSenderAccountNo("123456789");
        request.setReceiverAccountNo("987654321");
        request.setName("John Doe");
        request.setAmount(1000.00);
        request.setOverseas(false); // Set to `true` if testing an overseas transaction
        request.setPassportNumber(null); // Set passport number if `overseas` is true

        ResponseEntity<TransactionResponse> response = paymentControllerDebit.handleDebitTransaction(request);
        assertEquals(200, response.getBody().getStatusCode());
    }

    @Test
    public void testCreditTransaction() {
        TransactionRequest request = new TransactionRequest();
        // Set request properties for local/overseas
        request.setSenderAccountNo("123456789");
        request.setReceiverAccountNo("987654321");
        request.setName("John Doe");
        request.setAmount(1000.00);
        request.setOverseas(false); // Set to `true` if testing an overseas transaction
        request.setPassportNumber(null); // Set passport number if `overseas` is true

        ResponseEntity<TransactionResponse> response = paymentControllerCredit.handleCreditTransaction(request);
        assertEquals(200, response.getBody().getStatusCode());
    }
}

