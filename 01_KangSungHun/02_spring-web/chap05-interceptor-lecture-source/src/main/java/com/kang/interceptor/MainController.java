package com.kang.interceptor;


// Controller Bean등록

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    // mainPage 메서드 생성
    // - /, /main
    @RequestMapping({"/","/main"})
    public String mainPage() {

        // - /resources/templates/main.html 포워드
        return "/main";
    }
}
