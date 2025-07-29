package com.example.W2_board0_jar.dao.join;

import com.example.W2_board0_jar.dto.join.JoinDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JoinDao {
    /**
     * 회원가입
     */
    void Join(Map<String, Object> paramMap);

    /**
     * 아이디 중복 체크
     */
    int checkDuplicateId(Map<String, Object> paramMap);
}
