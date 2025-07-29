package com.example.W2_board0_jar.controller.comcode;

import com.example.W2_board0_jar.dto.comcode.ComcodeDto;
import com.example.W2_board0_jar.service.comcode.ComcodeService;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ComcodeController {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();

    @Autowired
    ComcodeService comcodeService;

    /**
     * 코드 조회
     */
    @GetMapping("/selectComcode")
    @ResponseBody
    public List<ComcodeDto> getCommonCode(@RequestParam("codeType") String codeType) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("codeType", codeType);

        return comcodeService.SelectCommonCode(paramMap);
    }

}

