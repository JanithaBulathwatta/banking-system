package com.example.practice.service;

import com.example.practice.dto.*;
import org.springframework.stereotype.Service;


public interface UserService {

    BankResponse createAccount(UserDTO userDTO);

    BankResponse balanceEnquiry(EnquiryRequest request);

    String nameEnquiry(EnquiryRequest request);

    BankResponse creditAccount(CreditDebitRequest request);

    BankResponse debitAccount(CreditDebitRequest request);

    BankResponse transfer(TransferDTO transferDTO);

}
