package com.jinosoft.requestmapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

/* class level @RequestMapping
* - 요청 URL의 공통 시작 부분을 지정하는 어노테이션
* - 내부 핸들러 메서드에서 중복 URL을 작성하지 않아도 된다
*  */

@Controller
@RequestMapping("/order")
public class ClassMappingTestController {
  @GetMapping("/regist")
  public String getOrderRegist(Model model) {
    model.addAttribute("message","GET 방식의 주문 등록 핸들러 메서드  호출");
    return "mappingResult";
  }

  @PostMapping(value = {"/modify", "/delete"})
  public String postOrderModifyAndDelete(Model model, HttpServletRequest request) {
    String requestURI = request.getRequestURI();

    if (requestURI.endsWith("/modify")) {
      model.addAttribute("message", "POST 방식의 주문 수정 핸들러 호출");
    } else if (requestURI.endsWith("/delete")) {
      model.addAttribute("message", "POST 방식의 주문 삭제 핸들러 호출");
    }

    return "mappingResult";
  }


  @GetMapping("/detail/{orderNo}")
  public String getOrderDetail(Model model, @PathVariable("orderNo") int orderNo) {

    /* @PathVariable : URL 경로에 포함된 변수 값을 핸들러 메서드의 인자로 받을 때 사용합니다.
     * 변수명과 매개변수명이 일치해야 하며, 일치하지 않을 경우 @PathVariable("orderNo")와 같이 명시해야 합니다. */

    model.addAttribute("message", orderNo + "번 주문 상세 조회 핸들러 메서드 호출");

    return "mappingResult";
  }

  @GetMapping
  public String otherRequest(Model model) {
    model.addAttribute("message", "order 요청이긴 하지만,다른 기능은 준비 되지 않음.");
    return "mappingResult";
  }

}
