package com.example.W2_board0_jar.controller.board;

import com.example.W2_board0_jar.dto.board.BoardDto;
import com.example.W2_board0_jar.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/")
    public String SelectBoardList(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".boardList");


        int currentPage = paramMap.get("pageNum") != null ? Integer.parseInt((String) paramMap.get("pageNum")) : 1;
        int pageSize = paramMap.get("size") != null ? Integer.parseInt((String) paramMap.get("size")) : 10;
        int pageIndex = (currentPage - 1) * pageSize;

        paramMap.put("pageIndex", pageIndex);
        paramMap.put("pageSize", pageSize);

        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));
        paramMap.put("userName", session.getAttribute("userName"));

        List<BoardDto> boardList = boardService.SelectBoardList(paramMap);
        int totalElements = boardService.SelectBoardCount(paramMap);

        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        model.addAttribute("boardList", boardList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalElements", totalElements);

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

        // 이전글+다음글
        List<Map<String,Object>> sequenceList = boardService.selectBoardNextList(paramMap);
        model.addAttribute("sequenceList", sequenceList);

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
    public String BoardWrite(@RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + paramMap);

        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));

        boardService.BoardWrite(paramMap);

        return "redirect:/";
    }

    /**
     * 게시글 수정 화면
     */
    @RequestMapping("/board/update/{boardType}/{boardNum}")
    public String MoveUpdate(Model model, @PathVariable("boardType") String boardType,
                             @PathVariable("boardNum") int boardNum, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".MoveWrite");

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("boardType", boardType);
        paramMap.put("boardNum", boardNum);
        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));

        List<BoardDto> boardDetail = boardService.SelectBoardDetail(paramMap);

        model.addAttribute("boardDetail", boardDetail);
        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("creator", session.getAttribute("creator"));

        logger.info("   - paramMap : " + paramMap);

        return "update";
    }
    
    /**
     * 게시글 수정
     */
    @RequestMapping("/board/BoardModify")
    public String BoardModify(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".BoardModify");

        paramMap.put("userId", session.getAttribute("userId"));
        paramMap.put("creator", session.getAttribute("creator"));

        logger.info("   - paramMap : " + paramMap);

        try {
            boardService.UpdateBoard(paramMap);

        } catch (Exception e) {
            throw e;
        }

        logger.info("   - paramMap : " + paramMap);

        return "redirect:/";
    }

    /**
     * 게시글 삭제
     */
    @RequestMapping("/board/delete")
    public String BoardDelete(@RequestParam Map<String, Object> paramMap) throws Exception {

        logger.info("+ Start " + className + ".BoardDelete");
        logger.info("   - paramMap : " + paramMap);

        try {
            boardService.BoardDelete(paramMap);

        } catch (Exception e) {
            throw e;
        }

        return "redirect:/";

    }
}