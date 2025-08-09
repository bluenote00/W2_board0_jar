package com.example.W2_board0_jar.service.comcode;

import com.example.W2_board0_jar.dto.comcode.ComcodeDto;

import java.util.List;
import java.util.Map;

public interface ComcodeService {

    /**
     * 코드 조회
     */
    List<ComcodeDto> SelectCommonCode(Map<String, Object> paramMap) throws Exception;
}