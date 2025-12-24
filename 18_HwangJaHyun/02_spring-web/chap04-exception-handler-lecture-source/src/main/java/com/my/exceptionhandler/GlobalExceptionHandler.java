package com.my.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 전역에서 발생하는 예외를 처리하는 annotation
* */
@ControllerAdvice
public class GlobalExceptionHandler {

  /* Controller 레벨의 Exception 처리
   * 해당 컨트롤러 내부에서 발생하는 모든 예외를 잡아서 처리
   * 예외 종류는 선택 가능
   * @ExceptionHandler 사용
   *  */
  @ExceptionHandler(NullPointerException.class)
  public String nullPointerExceptionHandler(NullPointerException e) {
    System.out.println("전역 범위의 Exception Handler 동작");
    System.out.println("message : " + e.getMessage());
    return "error/nullPointer";
  }

  @ExceptionHandler(MemberRegistException.class)
  public String userExceptionHandler(MemberRegistException e, Model model) {
    System.out.println("전역 범위의 Exception Handler 동작");
    System.out.println("message : " + e.getMessage());
    model.addAttribute("exception", e);
    return "error/memberRegist";
  }

  /* 상위 타입을 이용해서 하위 타입 예외도 모두 잡아서 처리
  * -> @ExceptionHandler가 여러개 존재하는 경우 하위 타입이 우선 순위를 갖는다. */
  @ExceptionHandler(Exception.class) // 모든 예외의 최상위 부모, 자식 전부 들어올 수 있음 (다형성)
  public String defaultExceptionHandler(Exception e){



    return "error/default";
  }

}
