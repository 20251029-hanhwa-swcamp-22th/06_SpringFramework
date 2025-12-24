package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller Bean 등록
@Controller
public class MainController {

  // mainPage 메서드 생성
  // - "/", "/main"  모든 http method 매핑
  // - /resources/templates/main.html 포워드
  @RequestMapping ({"/", "/main"})
  public String mainPage(){
    return "main";
  }
}
