package com.my.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* Dispatcher Servlet은
* 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
* 그 과정은 컨트롤러 클래스의 핸들러 메서드에 선언된 다양한 @RequestMapping 설정 내용을 따른다.
*
* 웹 요청
* -> Dispatcher Servlet
* -> Handler Mapping(@Request Mapping)
* -> Handler Adapter
* -> @Controller
* -> 핸들러 메서드(menuRegist())
* */

// Bean등록
@Controller
public class MethodMappingTestController {

  // /menu/regist (a태그, GET방식)
  /* 1. http method 방식을 지정 X */
  //@RequestMapping("/menu/regist") // 실행 시 HandlerMapping 등록 어노테이션
  public String menuRegist(Model model){

    System.out.println("/menu/regist 매핑됨");
    // Model : 화면에 값 전달하는 객체(request scope)

    model.addAttribute("message", "신규 메뉴 등록용 핸들러 메서드 호출");

    /* 핸들러 메서드의 return 값은
    * 반환하고자 하는 view(html파일) 경로를 포함한 이름을 작성한다.
    * resources/templates/ 폴더 하위부터 작성
    * .html은 생략하여 작성
    * */
    return "mappingResult"; // resources/templates/mappingResult.html
  }

  /* 2. http method 방식을 지정 O */
  // @GetMapping
  @RequestMapping(value="/menu/regist", method= RequestMethod.GET)
  public String menuRegist2(Model model){
    model.addAttribute("message", "신규 메뉴 등록 호출");
    return ("mappingResult");
  }

  /* 3. http method 전용 어노테이션 */
  @PostMapping(value="/menu/regist")
  public String menuRegist3(Model model){
    model.addAttribute("message", "POST 방식 메뉴 추가 핸들러 메서드 호출");
    return ("mappingResult");
  }
}
