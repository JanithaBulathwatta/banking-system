package com.example.practice.service;

import com.example.practice.dto.TransactionDTO;
import com.example.practice.entity.Transaction;
import com.example.practice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceIMPL implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = Transaction.builder()
                .transactionType(transactionDTO.getTransactionType())
                .accountNumber(transactionDTO.getAccountNumber())
                .amount(transactionDTO.getAmount())
                .status("success")
                .build();

        transactionRepository.save(transaction);
        System.out.println("transaction saved");

    }
}
