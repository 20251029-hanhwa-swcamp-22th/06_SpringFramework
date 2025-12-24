package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* class level @RequestMapping
* - 요청 URL의 공통 시작 부분을 지정하는 어노테이션
* - 내부 핸들러 메서드에서 중복 URL을 작성하지 않아도 된다.
* */
@Controller // Bean 등록 + Controller(제어 역할)임을 명시
@RequestMapping("/order")
public class ClassMappingTestController {

  @GetMapping("/regist")
  public String registOrder(Model model) { //Model 화면에 전달
    model.addAttribute("message", "GET 방식의 주문 등록 핸들러 메서드 호출");

    return "mappingResult";
  }



}
