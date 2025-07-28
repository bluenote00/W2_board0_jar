package com.example.W2_board0_jar.controller.board;

import com.example.W2_board0_jar.dto.board.BoardDto;
import com.example.W2_board0_jar.service.board.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();

    @Autowired
    BoardService boardService;

    /**
     * 게시판 전체 리스트 조회
     */
    @RequestMapping("/boardList")
    public String SelectBoardList(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".boardList");
        logger.info("   - paramMap : " + paramMap);

        List<BoardDto> boardList = boardService.SelectBoardList(paramMap);

        model.addAttribute("boardList", boardList);
        model.addAttribute("userId", session.getAttribute("userId"));

        return "list";
    }
}