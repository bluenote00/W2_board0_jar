package com.example.W2_board0_jar.service.join;

import com.example.W2_board0_jar.dao.join.JoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinDao joinDao;

    @Override
    public int checkDuplicateId(Map<String, Object> paramMap) throws Exception {
        return joinDao.checkDuplicateId(paramMap);
    }

    @Override
    public int checkDuplicateName(Map<String, Object> paramMap) throws Exception {
        return joinDao.checkDuplicateName(paramMap);
    }

    @Override
    public int Join(Map<String, Object> paramMap) throws Exception {
        return joinDao.Join(paramMap);
    }
}
