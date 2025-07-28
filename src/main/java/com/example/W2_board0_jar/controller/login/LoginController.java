//package com.example.W2_board0_jar.controller.login;
//
//import com.example.W2_board0_jar.service.login.LoginService;
//import org.apache.log4j.LogManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class LoginController {
//
//    // Set logger
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    // Get class name for logger
//    private final String className = this.getClass().toString();
//
//
//    @Autowired
//    LoginService loginService;
//
//
//    @GetMapping("/login")
//    public String Login() {
//        return "1";
//    }
//
//    @GetMapping("/loginout")
//    public String Logout() {
//        return "0";
//    }
//}