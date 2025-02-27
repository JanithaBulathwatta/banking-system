package com.example.practice.service;

import com.example.practice.dto.MailDetails;

public interface MailService {

    void sendEmailAlert(MailDetails mailDetails);
}
