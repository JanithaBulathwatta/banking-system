package com.example.practice.controller;

import com.example.practice.dto.BankResponse;
import com.example.practice.dto.CreditDebitRequest;
import com.example.practice.dto.EnquiryRequest;
import com.example.practice.dto.UserDTO;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/createNewAccount")
    public BankResponse createNewAccount(@RequestBody UserDTO userDTO){
        return userService.createAccount(userDTO);

    }
    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);

    }
    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }
    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }
}
