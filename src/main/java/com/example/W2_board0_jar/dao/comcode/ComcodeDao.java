package com.example.W2_board0_jar.dao.comcode;

import com.example.W2_board0_jar.dto.comcode.ComcodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ComcodeDao {
    /**
     * 게시판 전체 리스트 조회
     */
    List<ComcodeDto> SelectCommonCode(Map<String, Object> paramMap);
}
