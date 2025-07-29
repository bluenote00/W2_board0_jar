package com.example.W2_board0_jar.service.join;

import com.example.W2_board0_jar.dao.join.JoinDao;
import com.example.W2_board0_jar.dto.join.JoinDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
    public List<JoinDto> Join(Map<String, Object> paramMap) throws Exception {
        return joinDao.Join(paramMap);
    }
}
