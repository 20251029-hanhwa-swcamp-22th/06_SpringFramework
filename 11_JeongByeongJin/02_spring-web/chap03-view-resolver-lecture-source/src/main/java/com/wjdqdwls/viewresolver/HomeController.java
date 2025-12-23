package com.wjdqdwls.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  // Http Method "/" 또는 "/main" 요청 처리하는 핸들러 메서드
  @RequestMapping({"/", "/main"})
  public String mainPage(){
    return "Main";
  }
}
