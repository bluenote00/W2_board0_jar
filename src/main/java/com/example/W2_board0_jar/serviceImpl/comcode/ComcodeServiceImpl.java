package com.example.W2_board0_jar.serviceImpl.comcode;

import com.example.W2_board0_jar.dao.comcode.ComcodeDao;
import com.example.W2_board0_jar.dto.comcode.ComcodeDto;
import com.example.W2_board0_jar.service.comcode.ComcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComcodeServiceImpl implements ComcodeService {

    @Autowired
    private ComcodeDao comcodeDao;

    @Override
    public List<ComcodeDto> SelectCommonCode(Map<String, Object> paramMap) throws Exception {
        return comcodeDao.SelectCommonCode(paramMap);
    }
}
