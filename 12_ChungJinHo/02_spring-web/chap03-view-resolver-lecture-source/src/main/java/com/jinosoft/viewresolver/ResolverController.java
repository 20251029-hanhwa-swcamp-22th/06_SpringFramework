package com.jinosoft.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

  /*
   * 핸들러 메소드가 요청을 처리하고 논리 뷰 이름을 반환하면 DispatcherServlet은 화면에서 데이터를 표시하도록 뷰 템플릿에
   * 제어권을 넘긴다.
   * 스프링 MVC에서는 다양한 전략에 맞게 뷰를 해석할 수 있는 ViewResolver 구현체 몇 가지가 있다.
   * 그 중 MVC 기본 설정에는 템플릿 명과 위치에 따른 뷰를 해석하는 InternalResourceViewResolver를 기본으로 사용하고
   * 있다.
   * prefix/suffix를 이용해 뷰 이름을 특정 애플리케이션 디렉터리에 대응시킨다.
   * InternalResourceViewResolver는 사용이 간단해서 좋기는 하지만 RequestDispatcher가 forward할 수
   * 있는 내부 리소스(jsp또는 서블릿)만 해석이 가능하기 때문에
   * 다른 뷰 템플릿을 사용하는 경우에는 다른 viewResolver를 사용해야 한다.
   * 타임리프 또한 동일한 방식의 뷰 리졸버인 ThymeleafViewResolver를 사용한다.
   * 다면 prefix가 resources/templates/ 이고 suffix가 .html 이다.
   */

  /**
   * 문자열로 뷰 이름을 반환하는 핸들러 메소드
   *
   * @param model 모델 객체
   * @return 뷰 이름
   */
  @GetMapping("string")
  public String stringReturning(Model model) {

    /*
     * 문자열로 뷰 이름을 반환한다는 것은 반환 후 ThymeleafViewResolver에게
     * resources/templates/를 prefix로 .html을 suffix로 하여
     * resources/templates/result.html 파일을 응답 뷰로 설정하라는 의미가 된다.
     *
     * [Forward 방식]
     * 기본적으로 View Name을 문자열로 반환하면 DispatcherServlet은 해당 뷰로 Forward한다.
     * Forward는 서버 내부에서 일어나는 호출이므로 클라이언트(브라우저)는 그 사실을 알지 못한다.
     * 따라서 URL 주소는 변경되지 않고 유지된다. (현재 요청: /string -> 유지)
     * 또한 HttpServletRequest, HttpServletResponse 객체가 유지되므로 Request Scope에 담긴 값들이
     * 유효하다.
     *
     * [사용 이유]
     * - 가장 일반적이고 직관적인 방식이다.
     * - 단순 조회나 검색 결과 페이지로 이동할 때 주로 사용한다.
     * - 모델 데이터가 뷰에 그대로 전달되므로 데이터 표현이 쉽다.
     */
    model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함...");

    return "result";
  }

  /**
   * 문자열로 뷰 이름을 반환하여 리다이렉트하는 핸들러 메소드
   *
   * @return 리다이렉트 경로
   */
  @GetMapping("string-redirect")
  public String stringRedirect() {

    /*
     * 접두사로 redirect:를 붙이면 forward 되지 않고 redirect 된다.
     *
     * [Redirect 방식]
     * redirect: 접두사를 붙이면 DispatcherServlet은 ViewResolver를 호출하지 않고
     * HttpServletResponse.sendRedirect()를 호출하여 클라이언트에게 새로운 URL로 요청하도록 응답한다.
     * 클라이언트는 응답받은 URL로 새로운 요청을 보내게 되므로 URL 주소가 변경된다. (현재 요청: /string-redirect ->
     * 변경: /)
     * 새로운 요청이 발생하므로 기존의 HttpServletRequest, HttpServletResponse 객체는 소멸되고
     * 새로운 Request, Response 객체가 생성된다. 따라서 Request Scope에 담긴 값들은 모두 소멸된다.
     *
     * [사용 이유]
     * - POST/PUT/DELETE 요청 후 새로고침 시 데이터가 재전송되는(중복 작업) 것을 방지하기 위해 사용한다. (PRG 패턴)
     * - 작업 완료 후 목록 페이지로 돌아가거나 메인 페이지로 이동할 때 주로 사용한다.
     */
    return "redirect:/";
  }

  /**
   * 문자열로 뷰 이름을 반환하면서 FlashAttribute를 사용하는 핸들러 메소드
   *
   * @param rttr 리다이렉트 시 속성 값을 저장할 RedirectAttributes 객체
   * @return 리다이렉트 경로
   */
  @GetMapping("string-redirect-attr")
  public String stringRedirectFlashAttribute(RedirectAttributes rttr) {

    /*
     * 리다이렉트 시 flash 영역에 담아서 redirect 할 수 있다.
     * 자동으로 모델에 추가되기 때문에 requestScope에서 값을 꺼내면 된다.
     * 세션에 임시로 값을 담고 소멸하는 방식이기 때문에 session에 동일한 키 값이 존재하지 않아야 한다.
     *
     * [RedirectAttributes]
     * 리다이렉트 시에는 새로운 요청이 발생하므로 Request Scope가 소멸되어 데이터를 전달할 수 없다.
     * 하지만 RedirectAttributes를 사용하면 리다이렉트 된 후의 요청(새로운 Request)에서도 데이터를 사용할 수 있도록
     * 해준다.
     * 내부적으로는 HttpSession에 데이터를 잠시 저장했다가, 리다이렉트 된 요청이 오면 Request Scope에 데이터를 옮겨 담고
     * 세션에서는 삭제한다.
     * 따라서 리다이렉트 된 화면에서는 Request Scope에서 값을 꺼내 사용할 수 있다. (일회성 데이터 전달에 유용)
     *
     * [왜 모든 데이터를 Session에 담지 않고 FlashAttribute를 사용하는가?]
     * 1. 세션 메모리 부담: Session은 서버의 메모리를 사용하며, 사용자 접속이 끊길 때까지(또는 타임아웃까지) 유지된다.
     * 모든 데이터를 세션에 담으면 동시 접속자가 많을 경우 서버 메모리가 부족해질 수 있다.
     * 2. 데이터 정합성 문제: 세션은 전역적으로 접근 가능하기 때문에, 의도치 않게 다른 페이지에서 데이터가 오염되거나 덮어씌워질 수 있다.
     * 3. 명시적인 수명 주기: FlashAttribute는 "다음 요청까지만" 유지되고 자동으로 소멸된다.
     * 리다이렉트 후 사용자에게 메시지를 한 번만 보여주고 싶을 때(예: "저장되었습니다"), 세션을 직접 관리(add -> remove)하는
     * 것보다 훨씬 안전하고 편리하다.
     *
     * [사용 이유]
     * - Redirect 후에도 사용자에게 알림 메시지나 처리 결과를 일회성으로 보여줘야 할 때 사용한다.
     * - URL에 파라미터를 노출하지 않고 데이터를 전달하고 싶을 때 유용하다.
     */
    rttr.addFlashAttribute("flashMessage1", "리다이렉트 attr 사용하여 redirect..");

    return "redirect:/";
  }

  /**
   * ModelAndView로 뷰 이름을 지정해서 반환하는 핸들러 메소드
   *
   * @param mv ModelAndView 객체
   * @return ModelAndView 객체
   */
  @GetMapping("modelandview")
  public ModelAndView modelAndViewReturning(ModelAndView mv) {

    /*
     * ModelAndView 타입은 모델과 뷰를 합친 개념이다.
     * 핸들러 어댑터가 핸들러 메소드를 호출하고 반환받은 문자열을 ModelAndView로 만들어 dispatcherServlet에 반환한다.
     * 이 때 문자열을 반환해도 되지만 ModelAndView를 미리 만들어서 반환할 수도 있다.
     *
     * 이 경우에도 뷰 이름을 문자열로 지정하고 별도의 redirect: 접두사가 없으므로 Forward 방식으로 동작한다.
     * 따라서 Request Scope가 유지되고 URL도 변경되지 않는다.
     *
     * [사용 이유]
     * - 모델 데이터와 뷰 이름을 하나의 객체로 묶어서 반환해야 할 때 사용한다.
     * - 과거 스프링 프레임워크(2.0 이전)와의 호환성을 유지하거나, 명시적인 객체 반환을 선호하는 경우에 사용한다.
     */
    mv.addObject("forwardMessage", "ModelAndView를 이용한 모델과 뷰 반환");
    mv.setViewName("result");

    return mv;
  }

  /**
   * ModelAndView로 뷰 이름을 반환하여 리다이렉트하는 핸들러 메소드
   *
   * @param mv ModelAndView 객체
   * @return ModelAndView 객체
   */
  @GetMapping("modelandview-redirect")
  public ModelAndView modelAndViewRedirect(ModelAndView mv) {

    /*
     * ModelAndView 객체에서도 동일하게 접두사로 redirect:를 붙이면 forward 되지 않고 redirect 된다.
     * 이 경우 새로운 요청이 발생하므로 Request Scope가 초기화된다.
     *
     * [사용 이유]
     * - ModelAndView를 사용하는 구조에서 리다이렉트 처리를 일관성 있게 유지하고 싶을 때 사용한다.
     */
    mv.setViewName("redirect:/");

    return mv;
  }

  /**
   * ModelAndView로 뷰 이름을 반환하면서 FlashAttribute를 사용하는 핸들러 메소드
   *
   * @param mv   ModelAndView 객체
   * @param rttr 리다이렉트 시 속성 값을 저장할 RedirectAttributes 객체
   * @return ModelAndView 객체
   */
  @GetMapping("modelandview-redirect-attr")
  public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr) {

    /*
     * ModelAndView 사용시에도 동일하게 RedirectAttributes 타입을 통해 redirect 시 속성 값을 저장할 수 있다.
     * 동작 방식은 String 반환 시의 RedirectAttributes와 동일하다.
     *
     * [사용 이유]
     * - ModelAndView 방식에서도 PRG 패턴 구현 및 일회성 메시지 전달이 필요할 때 사용한다.
     */
    rttr.addFlashAttribute("flashMessage2", "ModelAndview를 이용한 redirect attr");
    mv.setViewName("redirect:/");

    return mv;
  }

  /*
   * [총 정리: ViewResolver와 반환 방식 비교]
   *
   * 1. 반환 타입 비교
   * - String: 뷰 이름(Logical View Name)만 반환한다. 모델 데이터는 파라미터로 받은 Model 객체에 담는다. 코드가
   * 간결하다.
   * - ModelAndView: 뷰 이름과 모델 데이터를 함께 담아서 반환한다. 옛날 방식이지만 명시적으로 모델과 뷰를 묶어서 처리할 때
   * 유용하다.
   *
   * 2. 이동 방식 비교 (Forward vs Redirect)
   * - Forward (기본값):
   * - 서버 내부에서 이동 (URL 유지)
   * - Request Scope 유지 (Model 데이터 유지)
   * - 주로 단순 조회나 검색 결과 페이지로 이동할 때 사용
   * - 리소스 경로: "viewName"
   *
   * - Redirect (접두사 redirect:):
   * - 클라이언트에게 재요청 응답 (URL 변경)
   * - Request Scope 소멸 (새로운 요청 발생)
   * - 주로 C/U/D(생성, 수정, 삭제) 처리 후 새로고침 방지를 위해(PRG 패턴) 사용
   * - 리소스 경로: "redirect:/path"
   *
   * 3. 데이터 전달 (Redirect 시)
   * - 일반적인 Model: Redirect 시 Request Scope가 소멸되므로 데이터가 전달되지 않음.
   * - RedirectAttributes (Flash Attributes):
   * - 세션을 임시 저장소로 사용하여 Redirect 후에도 데이터를 전달 가능하게 함.
   * - 한 번 사용 후 자동 소멸되어 관리가 용이함.
   * - URL에 쿼리 파라미터로 노출되지 않음 (POST 방식처럼 내부적으로 전달).
   */
}
