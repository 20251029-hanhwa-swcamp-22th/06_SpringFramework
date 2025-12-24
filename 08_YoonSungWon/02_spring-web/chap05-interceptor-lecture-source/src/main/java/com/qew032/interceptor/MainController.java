package com.qew032.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller Bean 등록
@Controller
public class MainController {

        // mainPage 메서드 생성
        // - /,/main 모든 http method 매핑
        // - /resources/templates/main.html

        @RequestMapping({"/","/main"})
        public String mainPage(){
                return "main";
        }

}
