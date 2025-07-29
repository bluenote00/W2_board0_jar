package com.example.W2_board0_jar.service.join;

import com.example.W2_board0_jar.dao.join.JoinDao;
import com.example.W2_board0_jar.dto.join.JoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JoinService {

    @Autowired
    JoinDao joinDao;

    /**
     * 가입하기
     */
    public void Join(Map<String, Object> paramMap) throws Exception {
        return joinDao.Join(paramMap);
    }

    /**
     * 아이디 중복 체크
     */
    public int checkDuplicateId(Map<String, Object> paramMap) throws Exception {
        return joinDao.checkDuplicateId(paramMap);
    }
}
