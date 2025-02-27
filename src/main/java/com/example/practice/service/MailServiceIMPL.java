package com.example.practice.service;

import com.example.practice.dto.MailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceIMPL implements MailService {

    @Autowired
    private JavaMailSender mailSender;


    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmailAlert(MailDetails mailDetails) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderEmail);
            message.setTo(mailDetails.getRecipient());
            message.setSubject(mailDetails.getSubject());
            message.setText(mailDetails.getMessageBody());

            mailSender.send(message);
            System.out.println("Email sent successfully");
        }catch (MailException e) {
            throw new RuntimeException(e);
        }
    }
}
