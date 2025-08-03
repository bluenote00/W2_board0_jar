package com.example.W2_board0_jar.service.mail;

import com.example.W2_board0_jar.dao.join.JoinDao;
import com.example.W2_board0_jar.dao.mail.MailDao;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

@Service
public class MailService {

    @Autowired
    MailDao mailDao;

    private final JavaMailSender javaMailSender;

    /**
     * 인증번호 insert
     */
    public String RandomCode() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000);
        return String.valueOf(number);
    }


    /**
     * 메일 내용 템플릿
     */
    public MimeMessage createMessage(String to)throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        message.addRecipients(Message.RecipientType.TO, to);	//보내는 대상
        message.setSubject("회원가입 이메일 인증");		//제목

        String msgg = "";
        msgg += "<div style='margin:100px;'>";
        msgg += "<h1> 안녕하세요</h1>";
        msgg += "<br>";
        msgg += "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요<p>";
        msgg += "<br>";
        msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE : <strong>";
        msgg += number + "</strong>";	//메일 인증번호
        msgg += "</div>";
        message.setText(msgg, "utf-8", "html");
        message.setFrom(new InternetAddress("god0937@naver.com", "BulletBox"));

        return message;
    }

    /**
     * 인증번호 insert
     */
    public int insertRandomCode(Map<String, Object> paramMap) throws Exception {
        return mailDao.insertRandomCode(paramMap);
    }

    /**
     * 인증번호 체크
     */
    public int checkRandomCode(Map<String, Object> paramMap) throws Exception {
        return mailDao.checkRandomCode(paramMap);
    }
}
