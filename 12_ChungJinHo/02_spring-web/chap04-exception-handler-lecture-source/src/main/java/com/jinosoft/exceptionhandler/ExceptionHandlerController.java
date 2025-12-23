package com.jinosoft.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ExceptionHandlerController {

  /**
   * NullPointerException을 발생시키는 테스트 메소드입니다.
   * <p>
   * 해당 요청이 들어오면 의도적으로 NullPointerException을 발생시킵니다.
   * </p>
   *
   * @return 뷰 이름 (이 코드는 실행되지 않고 예외가 발생함)
   */
  @GetMapping("controller-null")
  public String nullPointerExceptionTest() {

    String str = null;
    System.out.println(str.charAt(0));

    return "/";
  }

  /**
   * 사용자 정의 예외인 MemberRegistException을 발생시키는 테스트 메소드입니다.
   * <p>
   * 해당 요청이 들어오면 의도적으로 MemberRegistException을 발생시킵니다.
   * </p>
   *
   * @return 뷰 이름 (이 코드는 실행되지 않고 예외가 발생함)
   * @throws MemberRegistException 회원 가입 조건 불만족 시 발생하는 예외
   */
  @GetMapping("controller-user")
  public String userExceptionTest() throws MemberRegistException {

    boolean check = true;
    if (check) {
      throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다!");
    }

    return "/";
  }

  /**
   * 해당 컨트롤러에서 NullPointerException이 발생했을 때 처리하는 핸들러입니다.
   *
   * @param exception 발생한 예외 객체
   * @return 에러 페이지 뷰 이름
   */
  @ExceptionHandler(NullPointerException.class)
  public String nullPointerExceptionHandler(NullPointerException exception) {

    System.out.println("controller 레벨의 exception 처리");

    return "error/nullPointer";
  }

  /**
   * 해당 컨트롤러에서 MemberRegistException 발생했을 때 처리하는 핸들러입니다.
   *
   * @param model     뷰에 데이터를 전달하기 위한 Model 객체
   * @param exception 발생한 예외 객체
   * @return 에러 페이지 뷰 이름
   */
  @ExceptionHandler(MemberRegistException.class)
  public String userExceptionHandler(Model model, MemberRegistException exception) {

    System.out.println("controller 레벨의 exception 처리");
    model.addAttribute("exception", exception);

    return "error/memberRegist";
  }
}
