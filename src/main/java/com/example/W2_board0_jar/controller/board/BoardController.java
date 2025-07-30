package com.example.W2_board0_jar.controller.board;

import com.example.W2_board0_jar.dto.board.BoardDto;
import com.example.W2_board0_jar.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/")
    public String SelectBoardList(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".boardList");

        List<BoardDto> boardList = boardService.SelectBoardList(paramMap);
        int totalElements = boardService.SelectBoardCount(paramMap);

        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));
        paramMap.put("userName", session.getAttribute("userName"));

        model.addAttribute("boardList", boardList);
        model.addAttribute("totalElements", totalElements);
        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("creator", session.getAttribute("creator"));
        model.addAttribute("userName", session.getAttribute("userName"));

        logger.info("   - paramMap : " + paramMap);

        return "list";
    }

    /**
     * 게시글 상세보기
     */
    @RequestMapping("/board/read")
    public String SelectBoardDetail(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".boardDetail");

        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));
        paramMap.put("userName", session.getAttribute("userName"));

        List<BoardDto> boardDetail = boardService.SelectBoardDetail(paramMap);

        model.addAttribute("boardDetail", boardDetail);
        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("creator", session.getAttribute("creator"));
        model.addAttribute("userName", session.getAttribute("userName"));

        logger.info("   - paramMap : " + paramMap);

        return "read";
    }

    /**
     * 게시글 작성 화면
     */
    @RequestMapping("/board/register")
    public String MoveWrite(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".MoveWrite");

        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));
        paramMap.put("userName", session.getAttribute("userName"));

        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("creator", session.getAttribute("creator"));
        model.addAttribute("userName", session.getAttribute("userName"));


        logger.info("   - paramMap : " + paramMap);

        return "register";
    }

    /**
     * 게시글 작성
     */
    @RequestMapping("/board/boardwrite")
    public String BoardWrite(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + paramMap);

        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));

        boardService.BoardWrite(paramMap);

        return "redirect:/";
    }

}