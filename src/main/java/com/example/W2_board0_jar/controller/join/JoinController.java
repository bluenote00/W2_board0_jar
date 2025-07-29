package com.example.W2_board0_jar.controller.join;

import com.example.W2_board0_jar.dto.board.BoardDto;
import com.example.W2_board0_jar.dto.join.JoinDto;
import com.example.W2_board0_jar.service.join.JoinService;
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
public class JoinController {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();

    @Autowired
    JoinService joinService;

    /**
     * 가입하기 화면
     */
    @RequestMapping("/member/join")
    public String MoveJoin(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".MoveJoin");

        return "join";
    }

    /**
     * 가입하기
     */
    @RequestMapping("/submit/join")
    public String Join(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".Join");

        List<JoinDto> userJoin = joinService.Join(paramMap);

        model.addAttribute("userJoin", userJoin);

        logger.info("   - paramMap : " + paramMap);

        return "join";
    }

}