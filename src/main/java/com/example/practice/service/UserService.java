package com.example.practice.service;

import com.example.practice.dto.BankResponse;
import com.example.practice.dto.CreditDebitRequest;
import com.example.practice.dto.EnquiryRequest;
import com.example.practice.dto.UserDTO;
import org.springframework.stereotype.Service;


public interface UserService {

    BankResponse createAccount(UserDTO userDTO);

    BankResponse balanceEnquiry(EnquiryRequest request);

    String nameEnquiry(EnquiryRequest request);

    BankResponse creditAccount(CreditDebitRequest request);

    BankResponse debitAccount(CreditDebitRequest request);

}
