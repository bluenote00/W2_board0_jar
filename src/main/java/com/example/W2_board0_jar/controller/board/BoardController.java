package com.example.W2_board0_jar.controller.board;

import com.example.W2_board0_jar.service.board.BoardService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String SelectBoardList() {
        return "list";
    }

    @GetMapping("/listdetail")
    public String SelectBoardDetail() {
        return "1";
    }

    @GetMapping("/boardcount")
    public String SelectBoardCount() {
        return "1";
    }

    @GetMapping("/commoncode")
    public String SelectCommonCode() {
        return "1";
    }

    @GetMapping("/paging")
    public String Paging() {
        return "1";
    }
}