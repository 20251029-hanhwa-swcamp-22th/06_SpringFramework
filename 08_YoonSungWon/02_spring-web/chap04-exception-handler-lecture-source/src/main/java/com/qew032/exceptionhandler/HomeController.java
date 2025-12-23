package com.qew032.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

        @RequestMapping({"/", "/main"})
        public String mainPage() {

                return "main";
        }

        // 의도적으로 MemberRegistException 던지는 핸들러 메서드
        @GetMapping("/controller-user")
        public String userExceptionTest(){
                boolean check = true;
                if(check) throw new MemberRegistException("당신 같은 사람은 회원으로 받아줄 수 없어");
                return "/";
        }




}
