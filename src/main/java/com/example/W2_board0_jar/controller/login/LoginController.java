package com.example.W2_board0_jar.controller.login;

import com.example.W2_board0_jar.dto.join.JoinDto;
import com.example.W2_board0_jar.service.login.LoginService;
import com.example.W2_board0_jar.service.mail.MailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    MailService mailService;

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();

    @RequestMapping("/member/moveLogin")
    public String movelogin(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start LoginController.login");

        return "login";
    }


    /**
     * 로그인 처리
     */
    @PostMapping("/member/login")
    public String login(@ModelAttribute JoinDto joinDto, Model model, HttpSession session) throws Exception {

            Map<String, Object> result = loginService.login(joinDto);

            logger.info("+ Start LoginController.login2" + result);

        if ("success".equals(result.get("status"))) {
            session.setAttribute("userId", result.get("userId"));
            session.setAttribute("userName", result.get("userName"));
            session.setAttribute("creator", result.get("creator"));

            logger.info("+ 로그인 성공" + result);

            return "redirect:/";

        } else {
            model.addAttribute("errorMessage", result.get("message"));
            return "login";
        }
    }

    /**
     * 로그아웃
     */
    @RequestMapping(value = "/member/logout")
    public String loginOut(HttpSession session) {

        session.invalidate();

        return "login";
    }

    /**
     * 아이디 찾기 화면 이동
     */
    @RequestMapping("/member/movefindID")
    public String movefindID(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start movefindID");

        return "findID";
    }

    /**
     * 비밀번호 찾기 화면 이동
     */
    @RequestMapping("/member/movefindPW")
    public String movefindPW(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start movefindID");

        return "findPW";
    }

    /**
     * 아이디 찾기 (메일로 아이디 발송)
     */
    @GetMapping("/member/findID")
    @ResponseBody
    public String findID(@RequestParam("userEmail") String userEmail, HttpSession session) {

            logger.info("+ Start UserEmail : " + userEmail);

        try {
            // 이메일로 ID 검색
            String findUserId = loginService.findUserId(userEmail);

            logger.info("+ Start UserId : " + findUserId);

            // ID가 없는 경우
            if (findUserId == null || findUserId.isEmpty()) {
                return "3";
            }

            // 메일 전송
            mailService.sendFindIDMail(userEmail, findUserId);
            return "1";

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * 비밀번호 찾기  (메일로 비밀번호 발송)
     */
    @GetMapping("/member/findPW")
    @ResponseBody
    public String findPW(@RequestParam("userEmail") String userEmail, HttpSession session) {

        logger.info("+ Start UserEmail : " + userEmail);

        try {
            // 이메일로 ID 검색
            String findUserId = loginService.findUserId(userEmail);

            logger.info("+ Start UserPW : " + findUserId);

            // ID가 없는 경우
            if (findUserId == null || findUserId.isEmpty()) {
                return "3";
            }

            String findUserPW = loginService.findUserPW(findUserId);

            // 메일 전송
            mailService.sendFindPWMail(userEmail, findUserPW);

            return "1";

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }
}
