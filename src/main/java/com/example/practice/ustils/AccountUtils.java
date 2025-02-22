package com.example.practice.ustils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXIST_CODE = "001";
    public static final String ACCOUNT_EXIST_MESSAGE = "this user already has an account";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account creation successful";

    public static String generateAccountNumber() {

        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        int randomNumber = (int)Math.floor(Math.random() * (max-min+1)+min);

        String year = String.valueOf(currentYear);
        String randNumber = String.valueOf(randomNumber);
        StringBuilder accountNumber = new StringBuilder();

        return accountNumber.append(year).append(randNumber).toString();

    }
}
