package com.qew032.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 메인 페이지 요청을 처리하는 컨트롤러 */
@Controller
public class HomeController {

        // Http Method 종류 관계 없이 "/" 또는 "/main" 요청 처리하는
        // 핸들러 메서드
        @RequestMapping({"/", "/main"})
        public String mainPage() {
                return "main";
        }

}
