package com.example.W2_board0_jar.service.login;

import com.example.W2_board0_jar.dto.join.JoinDto;

import java.util.Map;

public interface LoginService {
    Map<String, Object> login(JoinDto joinDto) throws Exception;

    String findUserId(String userEmail) throws Exception;

    String findUserPW(String userEmail) throws Exception;
}
