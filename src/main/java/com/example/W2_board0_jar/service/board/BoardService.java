package com.example.W2_board0_jar.service.board;

import com.example.W2_board0_jar.dto.board.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface BoardService {

    // 게시판 전체 리스트 조회
    List<BoardDto> SelectBoardList(Map<String, Object> paramMap) throws Exception;

    // 게시판 전체 글 갯수
    int SelectBoardCount(Map<String, Object> paramMap) throws Exception;

    // 게시글 상세보기
    List<BoardDto> SelectBoardDetail(Map<String, Object> paramMap) throws Exception;

    // 이전글+다음글
    List<Map<String, Object>> selectBoardNextList(Map<String, Object> map) throws Exception;

    // 게시글 작성
    int BoardWrite(Map<String, Object> paramMap, MultipartFile file) throws Exception;

    // 게시글 수정
    int UpdateBoard(Map<String, Object> paramMap) throws Exception;

    // 게시글 삭제
    int BoardDelete(Map<String, Object> paramMap) throws Exception;
}
