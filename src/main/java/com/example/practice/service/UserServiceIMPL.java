package com.example.practice.service;

import com.example.practice.dto.*;
import com.example.practice.entity.User;
import com.example.practice.repository.UserRepository;
import com.example.practice.ustils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

    @Override
    public BankResponse createAccount(UserDTO userDTO) {

        if(userRepository.existsByEmail(userDTO.getEmail())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXIST_MESSAGE)
                    .accountInfo(null)
                    .build();

        }

        User newUser = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .gender(userDTO.getGender())
                .Address(userDTO.getAddress())
                .stateOfOrigin(userDTO.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .alternativePhoneNumber(userDTO.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();

        User savedUser = userRepository.save(newUser);

        MailDetails mailDetails = MailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("New Account Created")
                .messageBody("congrats your account has been created.\n your account details: \n" +
                        "Account Name: " + savedUser.getFirstName() + " " + savedUser.getLastName() + "\n" +
                        "Account Number: "+savedUser.getAccountNumber())
                .build();

        mailService.sendEmailAlert(mailDetails);

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(savedUser.getFirstName() + " " + savedUser.getLastName())
                        .build())
                .build();
    }

    @Override
    public BankResponse balanceEnquiry(EnquiryRequest request) {

        //check if the provided account number exists in the db
        boolean isAccountExists = userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExists) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_EXITS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_EXITS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User foundUser = userRepository.findByAccountNumber(request.getAccountNumber());
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
                .responseMessage(AccountUtils.ACCOUNT_FOUND_SUCCESS_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(foundUser.getAccountBalance())
                        .accountNumber(foundUser.getAccountNumber())
                        .accountName(foundUser.getFirstName() + " " + foundUser.getLastName())
                        .build())
                .build();

    }

    @Override
    public String nameEnquiry(EnquiryRequest request) {

        boolean isAccountExists = userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExists) {
            return AccountUtils.ACCOUNT_NOT_EXITS_MESSAGE;
        }
        User foundUser = userRepository.findByAccountNumber(request.getAccountNumber());
        return foundUser.getFirstName() + " " + foundUser.getLastName();
    }

    @Override
    public BankResponse creditAccount(CreditDebitRequest request) {
        //checking if the account exists
        boolean isAccountExists = userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExists) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_EXITS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_EXITS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        User userToCredit = userRepository.findByAccountNumber(request.getAccountNumber());
        userToCredit.setAccountBalance(userToCredit.getAccountBalance().add(request.getAmount()));
        userRepository.save(userToCredit);

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREDITED_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREDITED_SUCCESS_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountName(userToCredit.getFirstName() +" "+ userToCredit.getLastName())
                        .accountBalance(userToCredit.getAccountBalance())
                        .accountNumber(userToCredit.getAccountNumber())
                        .build())
                .build();

    }

}
