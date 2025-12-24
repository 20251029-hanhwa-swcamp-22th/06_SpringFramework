package com.qew032.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

        // 의도적으로 NullPointerException을 던지는 핸들러 메서드
        @GetMapping("/controller-null")
        public String nullPointerExceptionTest(){
                String str = null;
                System.out.println(str.charAt(0));
                return "/";
        }

        /* Controller 레벨의 Exception 처리
         *  - 해당 컨트롤러 내부에서 발생하는 모든 예외를 잡아서 처리
         *  - 예외 종류는 선택 가능
         *  - @ExceptionHandler 사용
         * */

        @ExceptionHandler(NullPointerException.class)
        public String nullPointerExceptionHandler(NullPointerException e) {
                System.out.println("지역 범위의 Exception Handler 동작");
                System.out.println("message : " + e.getMessage());
                return "error/nullPointer";
        }

        @ExceptionHandler(MemberRegistException.class)
        public String userExceptionHandler(MemberRegistException e, Model model) {
                System.out.println("지역 범위의 Exception Handler 동작");
                System.out.println("message : " + e.getMessage());
                model.addAttribute("exception", e);
                return "error/memberRegist";
        }

}
