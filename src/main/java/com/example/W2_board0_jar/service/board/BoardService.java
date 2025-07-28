package com.example.W2_board0_jar.service.board;

import com.example.W2_board0_jar.dao.board.BoardDao;
import com.example.W2_board0_jar.dto.board.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();

    @Autowired
    BoardDao dao;

    /**
     * 게시판 전체 리스트 조회
     */
    public List<BoardDto> SelectBoardList(Map<String, Object> paramMap) throws Exception {
        return dao.SelectBoardList(paramMap);
    }
}
