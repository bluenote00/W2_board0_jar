//package com.example.W2_board0_jar.controller.login;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import java.io.IOException;
//
//public class LoginInterceptor implements HandlerInterceptor {
//    // Set logger
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    // Get class name for logger
//    private final String className = this.getClass().toString();
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//
//        // 로그인 페이지, 정적 리소스는 통과
//        if (request.getRequestURI().contains("/member/moveLogin")) {
//            return true;
//        }
//
//        // 세션에 로그인 정보(userId)가 있으면 통과
//        if (request.getSession().getAttribute("userId") != null) {
//            return true;
//        }
//
//        // 로그인 안 되어있으면 로그인 페이지로 리다이렉트
//        response.sendRedirect("/member/moveLogin");
//        return false;
//    }
//
//}