package com.example.W2_board0_jar.service.join;

import java.util.Map;

public interface JoinService {

    /**
     * 아이디 중복 체크
     */
    int checkDuplicateId(Map<String, Object> paramMap) throws Exception;

    /**
     * 닉네임 중복 체크
     */
    int checkDuplicateName(Map<String, Object> paramMap) throws Exception;

    /**
     * 가입하기
     */
    int Join(Map<String, Object> paramMap) throws Exception;
}
