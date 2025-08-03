package com.example.W2_board0_jar.dao.login;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginDao {
        // 계정 확인
        Map<String, Object> selectUserByLoginId(String userId);

        // 아이디 찾기
        String findUserId(String userEmail);

        // 아이디 찾기
        String findUserPW(String userId);
    }

