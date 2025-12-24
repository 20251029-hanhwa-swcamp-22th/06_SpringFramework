package com.my.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

  @GetMapping("/string")
  public String stringReturning(Model model){

    model.addAttribute("forwardMessage","문자열 뷰 이름 반환");

    /* View Resolver
    * - 핸들러 메서드에서 반환되는 뷰 이름에 prefix/suffix를 붙여
    *   forward할 view 경로를 완성시킨 후 대응시키는 객체
    *
    * (기본값)
    * prefix : /resources/templates/
    * suffix : .html
    * */

    // /resources/templates/result.html
    return "result";
  }

  @GetMapping("string-redirect")
  public String stringRedirect(Model model){
    /* redirect(재요청) -> request 유지 X
    * 클라이언트에게 지정된 주소로 다시 요청하라고 지시
    * spring에서는 "redirect:요청주소" 를 반환하면 */
    model.addAttribute("flashMessage", "test");

    return "redirect:/";
  }

  /* RedirectAttributes
  * Redirect시 request scope를 이용하면 데이터를 이용할 수 없다.
  * (model.addAttribute()만 사용해서 전달 불가)
  *
  * Redirect 시 전달되는 데이터를 잠시 session scope에 올려놨다가
  * Redirect 완료 후 다시 request scope로 내리는 방법으로 데이터를 유지할 수 있다.
  *
  * 전부 session에 올리면 되는 거 아닐까?
  * -> session에 데이터가 많으면 서버 성능에 영향을 주기 때문에 좋지 않음.
  * */
  @GetMapping("string-redirect-attr")
  public String stringRedirectFlashAttribute(RedirectAttributes rttr) {

    rttr.addFlashAttribute("flashMessage1", "리다이렉트 attr 사용하여 redirect..");

    return "redirect:/";
  }

  /* ModelAndView
  *  - Model과 View 정보를 한 번에 담아서 반환하는 용도의 객체
  * */
  @GetMapping("modelandview")
  public ModelAndView modelAndViewReturning(ModelAndView mv) {

    mv.addObject("forwardMessage", "ModelAndView를 이용한 모델과 뷰 반환");

    mv.setViewName("result");
    // -> View Resolver에 의해서
    // /resouces/templates/result.html 합쳐서 forward

    return mv;

    // 요청에 따른 응답 화면을 다르게
    // parameter에 따라 다른 html로 연결.. 근데 요즘은 안씀
    // 참고만
  }

  @GetMapping("modelandview-redirect")
  public ModelAndView modelAndViewRedirect(ModelAndView mv)  {

    mv.setViewName("redirect:/");

    return mv;
  }
}
