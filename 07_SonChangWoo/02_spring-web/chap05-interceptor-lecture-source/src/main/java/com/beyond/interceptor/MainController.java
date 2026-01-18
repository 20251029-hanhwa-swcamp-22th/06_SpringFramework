package com.beyond.interceptor;

// Controller Bean 등록

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  // mainPage 메서드 생성
  // - /, /main 모든 http method 매핑
  // - /resoruces/templates/main.html 포워드
  @RequestMapping({"/", "/main"})
  public String mainPage(){
    return "main";
  }

}
