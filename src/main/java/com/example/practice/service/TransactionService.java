package com.example.practice.service;

import com.example.practice.dto.TransactionDTO;
import com.example.practice.entity.Transaction;

public interface TransactionService {

    void saveTransaction(TransactionDTO transactionDTO);
}
