package com.example.W2_board0_jar.controller.login;

import com.example.W2_board0_jar.dto.join.JoinDto;
import com.example.W2_board0_jar.service.login.LoginService;
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
}
