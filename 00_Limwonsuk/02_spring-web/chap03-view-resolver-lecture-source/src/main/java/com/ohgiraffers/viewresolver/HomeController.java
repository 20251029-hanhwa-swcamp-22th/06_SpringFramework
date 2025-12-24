package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* main page 요청을 처리하는 컨트롤러 */
@Controller
public class HomeController {

    /* Http Method "/" || "/main" 요청 처리하는 핸들러 메서드 */

    @RequestMapping({"/","/main"})
    public String mainPage(){
        return "main";
    }
}
