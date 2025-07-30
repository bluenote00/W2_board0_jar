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

    @Autowired
    BoardDao dao;

    /**
     * 게시판 전체 리스트 조회
     */
    public List<BoardDto> SelectBoardList(Map<String, Object> paramMap) throws Exception {
        return dao.SelectBoardList(paramMap);
    }

    /**
     * 게시판 전체 글 갯수
     */
    public int SelectBoardCount(Map<String, Object> paramMap) throws Exception {
        return dao.SelectBoardCount(paramMap);
    }

    /**
     * 게시글 상세보기
     */
    public List<BoardDto> SelectBoardDetail(Map<String, Object> paramMap) throws Exception {
        return dao.SelectBoardDetail(paramMap);
    }

    /**
     * 게시글 작성
     */
    public int BoardWrite(Map<String, Object> paramMap) throws Exception {
        return dao.BoardWrite(paramMap);
    }

    /**
     * 게시글 수정
     */
    public void updateBoard(Map<String, Object> paramMap) throws Exception {
        dao.updateBoard(paramMap);
    }
}
