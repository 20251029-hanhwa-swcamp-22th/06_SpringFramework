package com.qew032.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/* Dispatcher Servlet은 웹 요청을 받는 즉시
 *  @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
 *  그 과정은 컨트롤러 클래스의 핸들러 메서드에 선언된
 *  다양한 @RequestMapping 설정 내용을 따른다.
 *
 *  웹 요청
 *  -> Dispatcher Servlet
 *  -> Handler Mapping(@RequestMapping)
 *  -> Handler Adaptor
 *  -> @Controller -> 핸들러 메서드(menuRegist())
 * */

// 빈 등록
@Controller
public class MethodMappingTestController {

        /* 1. http method 방식을 지정X */
        //@RequestMapping("/menu/regist")         // 핸들러 매핑 등록 어노테이션
        public String menuRegist(Model model) {
                System.out.println("/menu/regist 매핑됨");

                // Model : 화면에 값 전달하는 객체(request scope)
                model.addAttribute("message", "신규 메뉴 등록용 핸들러 메서드 호출!!");

                /* 핸들러 메서드의 return 값은
                 * 반환하고자 하는 view(html파일) 경로를 포함한 이름을 작성한다.
                 * resources/templates/ 폴더 하위부터 작성.
                 * .html은 생략하여 작성
                 * -> 자세한건 View Resolver 공부할 때 합시다
                 * */

                // forward
                return "mappingResult";         // // resources/templates/mappingResult.html
        }

        /* 2. http method 방식을 지정 O */
        // @GetMapping("/menu/regist")
        @RequestMapping(value="/menu/regist", method = RequestMethod.GET)
        public String menuRegist2(Model model){
                model.addAttribute("message", "신규 메뉴 등록 호출!");
                return "mappingResult";
        }

        /* 3. http method 전용 어노테이션 */
        @PostMapping("/menu/regist")
        public String postMenuRegist(Model model){
                model.addAttribute(
                        "message",
                        "POST 방식 메뉴 추가 핸들러 메서드 호출");

                return "mappingResult";
        }

        /* 4.  */
        @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
        public String getMenuModify(Model model) {

                // Model 객체 : 화면에 데이터를 전달하는 용도의 객체
                model.addAttribute("message","GET 방식 메뉴 수정");

                // forward
                // resources/templates/ 폴더 기준으로 파일 경로 작성
                // - 마지막 확장자 .html 생략
                return "mappingResult";

        }

        @RequestMapping(value = "/menu/modify", method = RequestMethod.POST)
        public String postMenuModify(Model model) {
                model.addAttribute("message","POST 방식 메뉴 수정");
                return "mappingResult";
        }

        @GetMapping("/menu/delete")
        public String getMenuDelete(Model model) {
                model.addAttribute("message","GET 방식 메뉴 삭제");
                return "mappingResult";
        }

        @PostMapping("/menu/delete")
        public String postMenuDelete(Model model) {
                model.addAttribute("message","POST 방식 메뉴 삭제");
                return "mappingResult";
        }

}
