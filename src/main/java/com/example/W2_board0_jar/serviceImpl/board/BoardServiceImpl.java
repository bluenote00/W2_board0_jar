package com.example.W2_board0_jar.serviceImpl.board;

import com.example.W2_board0_jar.dao.board.BoardDao;
import com.example.W2_board0_jar.dto.board.BoardDto;
import com.example.W2_board0_jar.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao dao;

    @Override
    public List<BoardDto> SelectBoardList(Map<String, Object> paramMap) throws Exception {
        return dao.SelectBoardList(paramMap);
    }

    @Override
    public int SelectBoardCount(Map<String, Object> paramMap) throws Exception {
        return dao.SelectBoardCount(paramMap);
    }

    @Override
    public List<BoardDto> SelectBoardDetail(Map<String, Object> paramMap) throws Exception {
        return dao.SelectBoardDetail(paramMap);
    }

    @Override
    public List<Map<String, Object>> selectBoardNextList(Map<String, Object> map) throws Exception {
        return dao.selectBoardNextList(map);
    }

    @Override
    public int BoardWrite(Map<String, Object> paramMap, MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";
            String uuid = UUID.randomUUID().toString();
            String fileName = uuid + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, fileName);
            file.transferTo(saveFile);

            paramMap.put("fileName", fileName);
            paramMap.put("fileRoot", "/files/" + fileName);
        } else {
            paramMap.put("fileName", "");
            paramMap.put("fileRoot", "");
        }

        return dao.BoardWrite(paramMap);
    }

    @Override
    public int UpdateBoard(Map<String, Object> paramMap) throws Exception {
        return dao.UpdateBoard(paramMap);
    }

    @Override
    public int BoardDelete(Map<String, Object> paramMap) throws Exception {
        return dao.BoardDelete(paramMap);
    }
}
