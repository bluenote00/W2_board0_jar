package com.example.W2_board0_jar.controller.join;

import com.example.W2_board0_jar.service.join.JoinService;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @RequestMapping("/member/moveJoin")
    public String MoveJoin(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".MoveJoin");

        return "join";
    }

    /**
     * 아이디 중복 체크
     */
    @GetMapping("/member/check-id")
    @ResponseBody
    public int checkDuplicateId(@RequestParam("userId") String userId) throws Exception {

        System.out.println("111111111111" + userId);
        logger.info("+ Start " + userId + ".checkDuplicateId");

        Map<String, Object> checkMap = new HashMap<>();
        checkMap.put("userId", userId);

        int duplicateCount = joinService.checkDuplicateId(checkMap);

        return duplicateCount;
    }

    /**
     * 가입하기
     */
//    @PostMapping("/member/join")
//    public String Join(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {
//
//        logger.info("+ Start " + className + ".Join");
//        logger.info("+ Start " + paramMap + ".Join");
//
//        int userJoin = joinService.Join(paramMap);
//
//        model.addAttribute("userJoin", userJoin);
//
//        logger.info("   - paramMap : " + paramMap);
//
//        return "join";
//    }

}