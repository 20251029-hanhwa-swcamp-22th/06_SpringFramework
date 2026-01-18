package com.beyond.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {
  @GetMapping("/other-controller-null")
  public String nullPointerExceptionTest() {
    String str = null;
    System.out.println(str.charAt(0));  // 의도적으로 NullPointerException 발생 시킴
    return "/";
  }

  @GetMapping("/other-controller-user")
  public String userExceptionTest() throws MemberRegistException {
    boolean check = true;
    if(check) throw new MemberRegistException("당신 같은 사람은 회원으로 다메다메");
    return "/";
  }

  @GetMapping("/other-controller-array")
  public String arrayExceptionTest() {
    double[] arr = new double[0];
    System.out.println(arr[0]);
    return "/";
  }
}