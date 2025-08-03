package com.example.W2_board0_jar.service.mail;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailService {

    public String RandomCode() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000);
        return String.valueOf(number);
    }
}
