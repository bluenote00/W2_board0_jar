package com.example.W2_board0_jar.dao.mail;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MailDao {
    /**
     * 인증번호 insert
     */
    int insertRandomCode(Map<String, Object> paramMap);

    /**
     * 인증번호 체크
     */
    int checkRandomCode(Map<String, Object> paramMap);
}
