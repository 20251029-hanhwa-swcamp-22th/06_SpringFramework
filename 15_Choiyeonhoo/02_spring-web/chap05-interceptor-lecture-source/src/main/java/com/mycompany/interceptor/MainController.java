package com.mycompany.interceptor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Controller Bean 등록 */
@Controller
public class MainController {

  // mainPage Method 생성
  @RequestMapping({"/","/main"})
  public String mainPage(){
    return "main";
  }
}
