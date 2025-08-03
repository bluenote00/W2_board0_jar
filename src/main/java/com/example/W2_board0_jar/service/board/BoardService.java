package com.example.W2_board0_jar.service.board;

import com.example.W2_board0_jar.dao.board.BoardDao;
import com.example.W2_board0_jar.dto.board.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
     * 이전글+다음글
     */
    public List<Map<String, Object>> selectBoardNextList(Map<String, Object> map) throws Exception {
        return dao.selectBoardNextList(map);
    }

    /**
     * 게시글 작성
     */
    public int BoardWrite(Map<String, Object> paramMap, MultipartFile file) throws Exception {

        if (!file.isEmpty()) {
        // 파일 업로드 처리 시작
        String projectPath = System.getProperty("user.dir")
        // 파일이 저장될 폴더의 경로
                + "/src/main/resources/static/files";

        // 랜덤으로 식별자를 생성
        String uuid = UUID.randomUUID().toString();

        // UUID와 파일이름을 포함된 파일 이름으로 저장
        String fileName = uuid + "_" + file.getOriginalFilename();

        // projectPath는 위에서 작성한 경로, name은 전달받을 이름
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);

        paramMap.put("fileName", fileName);
        paramMap.put("fileRoot", "/files/" + fileName);

        } else {
            paramMap.put("fileName", null);
            paramMap.put("fileRoot", null);
        }

        return dao.BoardWrite(paramMap);
    }

    /**
     * 게시글 수정
     */
    public int UpdateBoard(Map<String, Object> paramMap) throws Exception {
        return dao.UpdateBoard(paramMap);
    }

    /**
     * 게시글 삭제
     */
    public int BoardDelete(Map<String, Object> paramMap) throws Exception {
        return dao.BoardDelete(paramMap);
    }
}
