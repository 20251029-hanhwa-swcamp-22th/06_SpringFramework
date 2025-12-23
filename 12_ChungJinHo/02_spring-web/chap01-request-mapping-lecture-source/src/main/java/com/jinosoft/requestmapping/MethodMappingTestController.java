package com.jinosoft.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/* Dispatcher Servlet은 웹 요청을 받는 즉시
*  @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
* 그 과정은 컨트롤러 클래스의 핸들러 메서드에 선언된
* 다양한 @RequestMapping 설정 내용을 따른다.
*
* 웹 요청 -> Dispatcher Survlet
* -> Handler Mapping(@RequestMapping)
* -> Handler Adaptor
* -> @Controller -> 핸들러 메서드(menuRegist())
*  */

@Controller
public class MethodMappingTestController {
  /* http method 방식을 지정 X */
  @RequestMapping("/menu/regist")
  public String menuRegist(Model model) {
    // Model : 화면에 값 전달하는 객체(request scope)

    model.addAttribute("message","신규 메뉴 등록용 핸들러 메서드 호출!!!");
    System.out.println( "/menu/regist 매핑");

    /* 핸들러 메서드의 return 값은
     * 반환하고자 하는 view(html 파일) 경로를 포함한 이름을 작성한다.
     * resources/templates/ 폴더 하위부터 작성.
     * .html은 생략
     *  */

    return "mappingResult";
  }

  /* value 속성에 중괄호를 이용해 매핑할 URL을 나열한다. */
  @RequestMapping(value="/menu/regist", method = RequestMethod.POST)
  public String menuRegist2(Model model) {

    model.addAttribute("message", "POST 방식");

    return "mappingResult";
  }

  @RequestMapping(value="/menu/modify", method = RequestMethod.GET)
  public String getMenuModify(Model model) {
    // Model 객체 : 화면에 데이터를 전달하는 용도의 객체
    model.addAttribute("message","GET 방식 메뉴 수정");
    return "mappingResult";
  }

  @RequestMapping(value="/menu/modify", method = RequestMethod.POST)
  public String postMenuModify(Model model) {
    model.addAttribute("message","POST 방식 메뉴 수정");
    return "mappingResult";
  }

  @GetMapping(value="/menu/delete")
  public String getMenuDelete(Model model) {
    // Model 객체 : 화면에 데이터를 전달하는 용도의 객체
    model.addAttribute("message","GET 방식 메뉴 삭제");
    return "mappingResult";
  }

  @PostMapping(value="/menu/delete")
  public String postMenuDelete(Model model) {
    model.addAttribute("message","POST 방식 메뉴 삭제");
    return "mappingResult";
  }

}
