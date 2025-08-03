package com.example.W2_board0_jar.controller.join;

import com.example.W2_board0_jar.service.join.JoinService;
import com.example.W2_board0_jar.service.mail.MailService;
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

    @Autowired
    MailService mailService;

    /**
     * 가입하기 화면
     */
    @RequestMapping("/member/moveJoin")
    public String MoveJoin(@RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".MoveJoin");

        return "join";
    }


    /**
     * 이메일 발송 (랜덤 코드 생성+메일 발송까지만)
     */

    @GetMapping("/member/sendmail")
    @ResponseBody
    public String sendEmail(@RequestParam("userEmail") String userEmail, HttpSession session) {
        try {
            // 인증번호 생성
            String authCode = mailService.createRandomCode();

            // 세션에 저장
            session.setAttribute("authCode", authCode);
            session.setAttribute("authEmail", userEmail);

            // 메일 전송
            mailService.sendVerificationMail(userEmail, authCode);

            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * 이메일 인증 (랜덤 코드 비교 후 인증 완료)
     */
    @GetMapping("/member/emailChecked")
    @ResponseBody
    public String emailChecked(@RequestParam("userCode") String userCode, HttpSession session) {

        System.out.println("userCode: " + userCode);

        String sessionCode = (String) session.getAttribute("authCode");
        System.out.println("sessionCode: " + sessionCode);

        if (sessionCode != null && sessionCode.equals(userCode)) {
            return "1";
        } else {
            return "0";
        }
    }


    /**
     * 아이디 중복 체크
     */
    @GetMapping("/member/check-id")
    @ResponseBody
    public int checkDuplicateId(@RequestParam("userId") String userId) throws Exception {

        logger.info("+ checkDuplicateId " + userId);

        Map<String, Object> checkMap = new HashMap<>();
        checkMap.put("userId", userId);

        int duplicateCount = joinService.checkDuplicateId(checkMap);

        logger.info("+ checkDuplicateId " + duplicateCount);
        return duplicateCount;
    }

    /**
     * 닉네임 중복 체크
     */
    @GetMapping("/member/check-name")
    @ResponseBody
    public int checkDuplicateName(@RequestParam("userName") String userName) throws Exception {

        logger.info("+ checkDuplicateName " + userName);

        Map<String, Object> checkMap = new HashMap<>();
        checkMap.put("userName", userName);

        int duplicateCount2 = joinService.checkDuplicateName(checkMap);

        logger.info("+ checkDuplicateName " + duplicateCount2);
        return duplicateCount2;
    }

    /**
     * 가입하기
     */
    @PostMapping("/member/join")
    public String Join(Model model, @RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".Join");
        logger.info(paramMap.toString());

        try {
            int result = joinService.Join(paramMap);

            if (result > 0) {
                logger.info("Insert 완료");

                return "redirect:/";

            } else {
                logger.warn("Insert 실패");

                return "join";
            }

        } catch (Exception e) {
            logger.error("오류 발생", e);

            return "join";
        }
    }



}