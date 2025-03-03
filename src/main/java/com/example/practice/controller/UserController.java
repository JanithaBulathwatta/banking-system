package com.example.practice.controller;

import com.example.practice.dto.*;
import com.example.practice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User account Management APIs")
public class UserController {

    @Autowired
    private UserService userService;
    @Operation(
            summary = "Create New User Account",
            description = "creating a new user and assigning an account ID"
    )
    @ApiResponse(
           responseCode = "201",
            description = "HTTP status 201 created"
    )
    //create account
    @PostMapping("/createNewAccount")
    public BankResponse createNewAccount(@RequestBody UserDTO userDTO){
        return userService.createAccount(userDTO);

    }

    @Operation(
            summary = "Balance Enquiry",
            description = "given an account number, check how much the user has "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
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
