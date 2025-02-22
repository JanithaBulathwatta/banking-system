package com.example.practice.service;

import com.example.practice.dto.BankResponse;
import com.example.practice.dto.UserDTO;
import org.springframework.stereotype.Service;


public interface UserService {

    BankResponse createAccount(UserDTO userDTO);
}
