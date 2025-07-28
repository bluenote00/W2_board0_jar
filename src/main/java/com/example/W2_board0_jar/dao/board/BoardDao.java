package com.example.W2_board0_jar.dao.board;

import com.example.W2_board0_jar.dto.board.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDao {
    /**
     * 게시판 전체 리스트 조회
     */
    List<BoardDto> SelectBoardList(Map<String, Object> paramMap);

    /**
     * 게시판 전체 글 갯수
     */
    int SelectBoardCount(Map<String, Object> paramMap);

    /**
     * 게시글 상세보기
     */
    List<BoardDto> SelectBoardDetail(Map<String, Object> paramMap);

    /**
     * 게시글 작성
     */
    List<BoardDto> BoardWrite(Map<String, Object> paramMap);
}
