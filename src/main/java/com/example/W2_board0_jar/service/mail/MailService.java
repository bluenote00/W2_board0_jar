package com.example.W2_board0_jar.service.mail;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 랜덤 6자리 인증번호 생성
     */
    public String createRandomCode() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000); // 100000 ~ 999999
        return String.valueOf(number);
    }

    /**
     * 메일 내용 생성
     */
    public MimeMessage createMessage(String to, String code) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        message.addRecipients(Message.RecipientType.TO, to);
        message.setSubject("회원가입 이메일 인증");

        String htmlContent =
                "<div style='margin:100px;'>"
                + "<h1>안녕하세요. </h1>"
                + "<p>아래 코드를 회원가입 창에 입력해주세요.</p>"
                + "<div style='border:1px solid #000; padding:20px; display:inline-block;'>"
                + "<h2>인증 코드: <span style='color:blue;'>" + code + "</span></h2>"
                + "</div>"
                + "</div>";

        message.setText(htmlContent, "utf-8", "html");
        message.setFrom(new InternetAddress("god0937@naver.com", "sunrising"));

        return message;
    }

    /**
     * 이메일 전송
     */
    public void sendVerificationMail(String to, String code) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = createMessage(to, code);
        javaMailSender.send(message);
    }
}
