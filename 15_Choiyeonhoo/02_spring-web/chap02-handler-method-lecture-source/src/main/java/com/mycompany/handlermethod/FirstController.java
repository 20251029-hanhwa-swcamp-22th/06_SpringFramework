package com.mycompany.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/first")
@SessionAttributes({"pwd"})
public class FirstController {

  /* 점점 반환형을 3가지만 씀
  - String
  - Void
  - ResponseEntity (RestAPI)
  */


  /* Handler Method의 반환형이 void이면
  * 요청 주소가 곧 view의 이름이 된다.
  * - 요청 주소 : /first/regist
  * - view(html) : /resources/templates/first/regist.html */
  @GetMapping("/regist")
  public void regist(){}


  /* ArgumentResolver(전달인자 해결사)
  * - 핸들러 메서드(Controller Method)가 호출 될 때,
  *   매개 변수에 작성된 변수에 맞게 인자를 준비해주는 해결사
  * 
  * -> 아래 예시 public String registMenu(Model model) 이라고 작성 한 경우, Model을 찾아서 준비해줌
  *
  * - ArgumentResolver의 리스트에 작성된 타입이 호출 되면
  *   자동으로 생성 또는 찾아서 주입
  * */

  /* 1. WebRequest로 요청 파라미터 전달 받기
  * - Servlet에서  HttpServletRequest를 이용해서 파라미터를 얻어올 수 있었음.
  * - WebRequest를 이용해 Servlet에 종속되지 않은
  *   Spring 기반 객체를 사용
  * */

  @PostMapping("/regist")
  public String registMenu(Model model, WebRequest req){

    String name = req.getParameter("name");
    int price = Integer.parseInt(req.getParameter("price"));
    int categoryCode = Integer.parseInt(req.getParameter("categoryCode"));

    String message = String.format("%s을/를 신규 메뉴 목록의 %d번 카테고리에, %d원으로 등록 했습니다.",name,categoryCode,price);

    model.addAttribute("message",message);
    return "first/messagePrinter";
  }

  @GetMapping("modify")
  public void modify() {}

  /* 2. @RequestParam
   * 요청 파라미터를 매핑하여 핸들러 메소드 호출 시 값을 넣어주는 어노테이션으로 매개변수 앞에 작성
   * name 속성과 매개변수명이 다른 경우 @RequestParam("name") 으로 작성하며 별도의 속성이
   * 필요 없을 경우에는 어노테이션 생략도 가능하다.
   * 전달하는 name 속성과 일치하는 것이 없는 경우 400 (Bad Request) 에러가 발생하는데
   * 이는 required = true 가 기본 값이기 때문이다.
   * 값을 입력하지 않고 넘기면 빈 문자열이 넘어오므로 parsing 관련 에러가 발생할 수 있다.
   * */
  @PostMapping("/modify")
  public String modifyMenu(
      Model model,
      @RequestParam(value="modifyName", required = false, defaultValue = "XXXX") String modifyName,
      @RequestParam(value="modifyPrice", defaultValue = "100") int modifyPrice  //@RequestParam의 경우 알아서 Parsing 해줌
//      @RequestParam int modifyPrice  // 전달받은 파라미터 이름과 같으면 value 생략 가능, 하지만, 생략하지 않는것을 추천
//      int modifyPrice  // @RequestParam 어노테이션도 생략 가능, 하지만, 생략하지 않는것을 추천
      ){

    String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";

    model.addAttribute("message",message);

    return "first/messagePrinter";
  }

  @PostMapping("modifyAll")
  public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) { // 맵으로 하면 하나씩 꺼내서 하나씩 parsing 해야함, 귀찮음 대신 @ModelAttribute 사용하면 좋음 -> search에서 사용하는거 보여줌

    String modifyMenu = parameters.get("modifyName2");
    int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));

    String message = "메뉴의 이름을 " + modifyMenu + "(으)로, 가격을 " + modifyPrice + "원 으로 변경하였습니다.";
    System.out.println(message);

    model.addAttribute("message", message);

    return "first/messagePrinter";
  }

  @GetMapping("search")
  public void search() {}

  /* 3. @ModelAttribute
  * - 제출되는 파라미터의 name이
  *   @ModelAttribute 옆에 작성된 객체의 필드명과 같다면
  *   해당 객체의 Setter를 이용해서 파라미터를 필드에 세팅
  *   -> 전달 받은 파라미터를 저장한 객체 == 커맨드 객체
  *
  * - () 내부에 속성명을 지정하면
  *   forward 되는 화면에서 꺼내 쓸 수 있다.
  * */
  @PostMapping("/search")
  public String searchMenu(@ModelAttribute("menu") MenuDTO menuDTO){

    System.out.println("menuDTO = " + menuDTO);

    return "first/searchResult";
  }

  @GetMapping("login")
  public void login() {}

  /* 4. @SessionAttributes
  * - Spring에서 제공하는 Session을 다루는 어노테이션
  * - 클래스 레벨에 작성해야함.
  * - 단독 사용 X, Model 객체와 같이 사용
  *
  * - 사용법
  * 1) @SessionAttributes({"key1","key2"}) 작성
  * 2) Model.addAttribute("key1", "value1")
  *   -> @SesstionAttributes에 등록된 "key1"이라는 key를 이용해서
  *     Model의 속성으로 추가하게 되면
  *     request가 아닌 session scope로 추가된다!.
  * */
  @PostMapping("login")
  public String loginTest(
      @RequestParam("id") String id,
      @RequestParam("pwd") String pwd,
      Model model){

    // Model에 속성을 추가하는 경우
    // Scope는 기본적으로 request
    model.addAttribute("id",id);

    model.addAttribute("pwd",pwd);

    return "first/loginResult";
  }

  /* @SesstionAttributes 만료
  * - SessionStatus 라는 세션 상태를 관리하는 스프링 객체를 얻어와
  *   SetComplete()로 세션을 만료시킨다.
  *
  * - HttpSession은 Servlet 기반 객체로
  *   @SessionAttributes와는 따로 관리가 되고 있다.
  *   -> 둘을 혼용해서 사용하고 있다면 -> WebSocket이나, interceptor 사용시 @SessionAttributes를 못쓰는 경우가 있다.
  *     만료 시, SessionStatus.setComplete()
  *             HttpSession.invalidate()
  *     둘을 모두 사용 해야 한다.*/

  @GetMapping("/logout")
  public String logoutTest(SessionStatus status) {

    /* 현재 컨트롤러 세션에 저장된 모든 정보를 제거한다. 개별 제거는 불가능하다. */
    status.setComplete();

    return "first/loginResult";
  }

  @GetMapping("/body")
  public void body() {}

  // @RequestBody : 요청에 담겨져 전달된 값 - RestAPI 에서 ResponseBody 와 함께 많이 쓸 예정
  @PostMapping("/body")
  public String bodyTest(
      @RequestBody String body,
      @RequestHeader("content-type") String contentType,
      @CookieValue(value="JSESSIONID", required = false) String sessionId
      ){
    System.out.println("body = " + body);
    System.out.println(URLDecoder.decode(body));
    System.out.println(contentType);
    System.out.println(sessionId);
    // /first/body (GET) 재요청
    return "redirect:body";
  }



}
