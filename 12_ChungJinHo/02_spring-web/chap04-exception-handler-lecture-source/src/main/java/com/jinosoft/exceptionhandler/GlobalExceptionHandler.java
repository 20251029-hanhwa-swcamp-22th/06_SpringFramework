package com.jinosoft.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 전역 예외 처리를 담당하는 클래스입니다.
 * <p>
 * 
 * @ControllerAdvice 어노테이션을 사용하여 모든 컨트롤러에서 발생하는 예외를 감지하고 처리합니다.
 *                   </p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 전역 레벨에서 NullPointerException을 처리하는 핸들러입니다.
     *
     * @param exception 발생한 예외
     * @return 에러 뷰 이름
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("Global 레벨의 exception 처리");

        return "error/nullPointer";
    }

    /**
     * 전역 레벨에서 MemberRegistException을 처리하는 핸들러입니다.
     *
     * @param model     모델 객체
     * @param exception 발생한 예외
     * @return 에러 뷰 이름
     */
    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model, MemberRegistException exception) {

        System.out.println("Global 레벨의 exception 처리");
        model.addAttribute("exception", exception);

        return "error/memberRegist";
    }

    /**
     * 상위 타입인 Exception을 처리하는 기본 핸들러입니다.
     * <p>
     * 구체적인 예외 핸들러가 정의되지 않은 다른 모든 예외를 처리합니다.
     * </p>
     *
     * @param exception 발생한 예외
     * @return 기본 에러 뷰 이름
     */
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception exception) {

        return "error/default";
    }
}
