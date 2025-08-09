package com.example.W2_board0_jar.service.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;

public interface MailService {
    String createRandomCode();

    MimeMessage createMessage(String to, String code) throws MessagingException, UnsupportedEncodingException;
    void sendVerificationMail(String to, String code) throws MessagingException, UnsupportedEncodingException;

    MimeMessage findIDMessage(String to, String userId) throws MessagingException, UnsupportedEncodingException;
    void sendFindIDMail(String to, String userId) throws MessagingException, UnsupportedEncodingException;

    MimeMessage findPWMessage(String to, String userPw) throws MessagingException, UnsupportedEncodingException;
    void sendFindPWMail(String to, String userPw) throws MessagingException, UnsupportedEncodingException;
}
