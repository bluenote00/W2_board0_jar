package com.example.W2_board0_jar.controller.login;

import com.example.W2_board0_jar.service.login.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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
//    @RequestMapping("/loginProc")
//    @ResponseBody
//    public Map<String, Object> loginProc(Model model, @RequestParam Map<String, Object> paramMap,
//                                         HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
//
//        logger.info("+ Start LoginController.loginProc.do");
//        logger.info("   - ParamMap : " + paramMap);
//
//        // 사용자 로그인
//        LgnInfoModel lgnInfoModel = loginService.loginProc(paramMap);
//
//        String result;
//        String resultMsg;
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//
//        if (lgnInfoModel != null) {
//            String userStatus = lgnInfoModel.getUser_status();
//            if (userStatus != null) {
//                // 가입 승인이 완료된 경우
//                // 로그인 처리 로직
//                // 사용자 메뉴 권한 조회
//                paramMap.put("usr_sst_id", lgnInfoModel.getUsr_sst_id());
//                paramMap.put("userType", lgnInfoModel.getMem_author());
//                // 메뉴 목록 조회 0depth
//                List<UsrMnuAtrtModel> listUsrMnuAtrtModel = loginService.listUsrMnuAtrt(paramMap);
//                // 메뉴 목록 조회 1depth
//                for (UsrMnuAtrtModel list : listUsrMnuAtrtModel) {
//                    Map<String, Object> resultMapSub = new HashMap<String, Object>();
//                    resultMapSub.put("lgn_Id", paramMap.get("lgn_Id"));
//                    resultMapSub.put("hir_mnu_id", list.getMnu_id());
//                    resultMapSub.put("userType", lgnInfoModel.getMem_author());
//                    list.setNodeList(loginService.listUsrChildMnuAtrt(resultMapSub));
//                }
//
//                session.setAttribute("loginId", lgnInfoModel.getLgn_id()); // 로그인 ID
//                session.setAttribute("userNm", lgnInfoModel.getUsr_nm()); // 사용자 성명
//                session.setAttribute("usrMnuAtrt", listUsrMnuAtrtModel);
//                session.setAttribute("userType", lgnInfoModel.getMem_author()); // 로그인 사용자 권한 (A: 관리자, C: 기업회원, P: 일반회원)
//                session.setAttribute("user_businesstype", lgnInfoModel.getUser_businesstype());
//                session.setAttribute("user_coname", lgnInfoModel.getUser_coname());
//                session.setAttribute("user_status", lgnInfoModel.getUser_status());
//
//                resultMap.put("loginId", lgnInfoModel.getLgn_id());
//                resultMap.put("userNm", lgnInfoModel.getUsr_nm());
//                resultMap.put("usrMnuAtrt", listUsrMnuAtrtModel);
//                resultMap.put("userType", lgnInfoModel.getMem_author());
//                resultMap.put("user_businesstype", lgnInfoModel.getUser_businesstype());
//                resultMap.put("user_coname", lgnInfoModel.getUser_coname());
//                resultMap.put("user_status", lgnInfoModel.getUser_status());
//
//                result = "SUCCESS";
//                resultMsg = "가입이 승인되었습니다.";
//            } else {
//                result = "FALSE";
//                resultMsg = "가입 승인 대기 중입니다.";
//            }
//        } else {
//            result = "FALSE";
//            resultMsg = "사용자 로그인 정보가 일치하지 않습니다.";
//        }
//
//        resultMap.put("result", result);
//        resultMap.put("resultMsg", resultMsg);
//
//        logger.info("+ End LoginController.loginProc.do");
//        logger.info("+ End LoginController.loginProc.do" + resultMap);
//
//        return resultMap;
//    }



    /**
     * 로그아웃
     * @param request
     * @param response
     * @param session
     * @return
     */
//    @RequestMapping(value = "/loginOut.do")
//    public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//
//        ModelAndView mav = new ModelAndView();
//        session.invalidate();
//
//        mav.setViewName("redirect:/login.do");
//
//        return mav;
//    }
}
