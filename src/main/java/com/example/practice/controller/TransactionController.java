package com.example.practice.controller;


import com.example.practice.entity.Transaction;
import com.example.practice.service.BankStatementIMPL;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bankStatement")
@AllArgsConstructor
public class TransactionController {

    private BankStatementIMPL bankStatementIMPL;

    @GetMapping
    public List<Transaction> generateBankStatement(@RequestParam String accountNumber,@RequestParam String startDate, @RequestParam String endDate ){

        return bankStatementIMPL.generateStatement(accountNumber,startDate,endDate);

    }

}
