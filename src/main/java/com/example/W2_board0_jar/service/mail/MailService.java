package com.example.W2_board0_jar.service.mail;

import com.example.W2_board0_jar.dao.join.JoinDao;
import com.example.W2_board0_jar.dao.mail.MailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
public class MailService {

    @Autowired
    MailDao mailDao;

    public String RandomCode() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000);
        return String.valueOf(number);
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
