package com.mycompany.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Class Level @RequestMapping
* - 요청 URL 의 공통 시작 부분을 지정하는 어노테이션
* - 내부 핸들러 메서드에서 중복 URL을 작성하지 않아도 된다. */

@Controller  // Bean 등록 + Controller임을 명시
@RequestMapping("/order")
public class ClassMappingTestController {

  @GetMapping("/regist")
  public String registOrder(Model model) {
    model.addAttribute("message", "Get 방식 주문 등록 핸들러 메서드 호출");
    return "mappingResult";
  }

  @PostMapping(value = {"/modify","/delete"})
  public String modifyAndDeleteOrder(Model model) {

    model.addAttribute("message", "Post 방식 주문 수정 또는 삭제 핸들러 메서드 호출");
    return "mappingResult";
  }

//  @PostMapping("/delete")
//  public String deleteOrder(Model model) {
//    model.addAttribute("message", "Post 방식 주문 삭제 핸들러 메서드 호출");
//    return "mappingResult";
//  }


  /* @PathVariable : 요청 주소에 포함된 값을 매개 변수에 저장
  * (요청 주소에 포함된 변수)
  * */
  @GetMapping("/detail/{orderNo}")
  public String detailOrder(Model model, @PathVariable("orderNo") int orderNo) {
    model.addAttribute("message", "Get 방식 " + orderNo + "번 메뉴 상세 주문 핸들러 메서드 호출");
    return "mappingResult";
  }

  /* /order (get) 요청 핸들러 메서드 */
  @GetMapping
  public String otherRequest(Model model){
    model.addAttribute("message", "order 요청이지만 다른 기능은 준비되어있지 않음");
    return "mappingResult";
  }

}
