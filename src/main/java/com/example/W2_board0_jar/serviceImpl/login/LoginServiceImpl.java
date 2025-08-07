package com.example.W2_board0_jar.serviceImpl.login;

import com.example.W2_board0_jar.dao.login.LoginDao;
import com.example.W2_board0_jar.dto.join.JoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl {

    @Autowired
    private LoginDao loginDao;

    /**
     * 로그인
     */
    public Map<String, Object> login(JoinDto joinDto) throws Exception {
        String userId = joinDto.getUserId();
        String password = joinDto.getUserPw();

        Map<String, Object> resultMap = new HashMap<>();

        // 아이디로 사용자 조회
        Map<String, Object> user = loginDao.selectUserByLoginId(userId);

        if (user == null) {
            resultMap.put("status", "null");
            resultMap.put("message", "존재하지 않는 회원입니다.");
        } else {
            String dbPassword = (String) user.get("USER_PW");

            if (password.equals(dbPassword)) {
                resultMap.put("status", "success");
                resultMap.put("message", "로그인되었습니다.");

                resultMap.put("userId", user.get("USER_ID"));
                resultMap.put("userName", user.get("USER_NAME"));
                resultMap.put("creator", user.get("CREATOR"));

            } else {
                resultMap.put("status", "fail");
                resultMap.put("message", "잘못된 비밀번호입니다.");
            }
        }

        return resultMap;
    }

    /**
     * 아이디 찾기
     */
    public String findUserId(String userEmail) throws Exception {
        return loginDao.findUserId(userEmail);
    }

    /**
     * 비밀번호 찾기
     */
    public String findUserPW(String userEmail) throws Exception {
        return loginDao.findUserPW(userEmail);
    }
}
