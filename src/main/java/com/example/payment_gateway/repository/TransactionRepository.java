package com.example.payment_gateway.repository;

import com.example.payment_gateway.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
