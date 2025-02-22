package com.example.practice.controller;

import com.example.practice.dto.BankResponse;
import com.example.practice.dto.UserDTO;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/createNewAccount")
    public BankResponse createNewAccount(@RequestBody UserDTO userDTO){
        return userService.createAccount(userDTO);

    }
}
