package com.jinosoft.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  // Http 종류 관계없이 "/" 또는 "/main" 욫펑 처리하는 핸들러 메서드
  @RequestMapping({"/","/main"})
  public String mainpage() {
    return "main";
  }
}
