package com.example.practice.controller;

import com.example.practice.dto.*;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //create account
    @PostMapping("/createNewAccount")
    public BankResponse createNewAccount(@RequestBody UserDTO userDTO){
        return userService.createAccount(userDTO);

    }
    //check balance
    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);

    }
    //check name
    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }

    //deposit
    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }

    //withdrawals
    @PostMapping("/debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }

    @PostMapping("/transfer")
    public BankResponse transferCreditDebit(@RequestBody TransferDTO transferDTO){
        return userService.transfer(transferDTO);
    }
}
