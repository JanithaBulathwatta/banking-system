package com.example.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailDetails {

    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;
}
