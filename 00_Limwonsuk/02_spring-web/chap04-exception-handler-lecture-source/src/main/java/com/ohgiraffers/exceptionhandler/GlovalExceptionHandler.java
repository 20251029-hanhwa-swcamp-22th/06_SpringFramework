package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 전역에서 발색하는 예외를 처리하는 어노테이션 */
@ControllerAdvice // 전역에서 예외를 처리하는 프로그램 어드바이스
public class GlovalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e) {
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());

        return "error/nullPointer"; // 기존대신 잡아서 표시할거다
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException e, Model model) {
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        model.addAttribute("exception", e); // 에러내용 추가해서 보여줄것

        return "error/memberRegist";
    }


    /* 상위 타입을 이용해서 하위 타입 예외도 모두 잡아서 처리
    *  -> @ExceptionHandler가 여러 개 존재하는 경우
    *       하위 타입이 우선 순위를 갖는다. */
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e){

        return "error/default";
    }
}
