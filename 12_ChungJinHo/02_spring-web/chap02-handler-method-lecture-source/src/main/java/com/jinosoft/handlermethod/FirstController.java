package com.jinosoft.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <pre>
 * Class : FirstController
 * Comment : 핸들러 메소드의 다양한 파라미터 전달 방식을 테스트하기 위한 컨트롤러입니다.
 *           Spring MVC에서 요청 파라미터를 처리하는 다양한 어노테이션과 객체 활용법을 다룹니다.
 * History
 * 2025-12-23 : 최초 생성 및 주석 보완
 * </pre>
 *
 * @author JinoSoft
 * @version 1.0
 */
@Controller
@RequestMapping("/first")
@SessionAttributes("id")
public class FirstController {

    /* ==================== @InitBinder ==================== */

    @InitBinder
    public void initBinder(org.springframework.web.bind.WebDataBinder binder) {
        binder.registerCustomEditor(int.class, new java.beans.PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text == null || text.trim().isEmpty()) {
                    setValue(0);
                } else {
                    setValue(Integer.parseInt(text));
                }
            }
        });
    }

    /* ==================== 1-1. WebRequest ==================== */

    /**
     * <pre>
     * WebRequest를 이용한 파라미터 전달 테스트 페이지로 이동합니다.
     * </pre>
     */
    @GetMapping("/regist")
    public void regist() {
    }

    /**
     * <pre>
     * WebRequest 객체를 이용하여 요청 파라미터를 직접 전달받는 메소드입니다.
     * HttpServletRequest와 유사하지만, WebRequest는 Spring이 제공하는 더 추상화된 인터페이스로,
     * Servlet API에 종속되지 않는다는 장점이 있습니다.
     * </pre>
     *
     * @param model   뷰에 전달할 데이터를 담는 객체
     * @param request 요청 정보를 담고 있는 WebRequest 객체
     * @return 결과 메시지를 출력할 뷰의 이름
     */
    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록 하셨습니다!";
        System.out.println(message);

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    /* ==================== 1-2. @RequestParam ==================== */

    /**
     * <pre>
     * @RequestParam 어노테이션을 이용한 파라미터 전달 테스트 페이지로 이동합니다.
     * </pre>
     */
    @GetMapping("modify")
    public void modify() {
    }

    /**
     * <pre>
     * @RequestParam 어노테이션을 이용하여 요청 파라미터를 개별 변수로 바인딩하는 메소드입니다.
     * required 속성을 통해 필수 여부를 지정할 수 있으며, defaultValue로 기본값을 설정할 수 있습니다.
     * 파라미터 이름과 변수 이름이 같으면 어노테이션을 생략할 수도 있습니다.
     * </pre>
     *
     * @param model       뷰에 전달할 데이터를 담는 객체
     * @param modifyName  수정할 메뉴 이름 (선택적)
     * @param modifyPrice 수정할 메뉴 가격 (기본값: 100)
     * @return 결과 메시지를 출력할 뷰의 이름
     */
    @PostMapping("modify")
    public String modifyMenu(Model model,
            @RequestParam(value = "modifyName", required = false, defaultValue = "XXX") String modifyName,
            @RequestParam(value = "modifyPrice", defaultValue = "100") int modifyPrice
    // @RequestParam int modifyPrice
    // int modifyPrice
    ) {

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 가격을 변경하였습니다.";
        System.out.println(message);

        model.addAttribute("message", message);

        return "first/messagePrinter";

    }

    /**
     * <pre>
     * @RequestParam을 이용하여 여러 파라미터를 Map으로 한 번에 전달받는 메소드입니다.
     * 파라미터의 개수가 많거나 동적으로 변할 때 유용하게 사용할 수 있습니다.
     * </pre>
     *
     * @param model      뷰에 전달할 데이터를 담는 객체
     * @param parameters 모든 요청 파라미터를 담은 Map
     * @return 결과 메시지를 출력할 뷰의 이름
     */
    @PostMapping("modifyAll")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {

        String modifyMenu = parameters.get("modifyName2");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = "메뉴의 이름을 " + modifyMenu + "(으)로, 가격을 " + modifyPrice + "원 으로 변경하였습니다.";
        System.out.println(message);

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    /* ==================== 1-3. @ModelAttribute ==================== */

    /**
     * <pre>
     * @ModelAttribute를 이용한 커맨드 객체 전달 테스트 페이지로 이동합니다.
     * </pre>
     */
    @GetMapping("search")
    public void search() {
    }

    /**
     * <pre>
     * @ModelAttribute 어노테이션을 이용하여 요청 파라미터를 자바 객체(DTO)로 매핑하는 메소드입니다.
     * 이를 '커맨드 객체'라고 부르며, 요청 파라미터의 이름과 객체의 필드명이 일치하면 자동으로 값이 설정됩니다.
     * &#64;ModelAttribute("menu")와 같이 이름을 지정하면 뷰에서 해당 이름으로 객채를 사용할 수 있습니다.
     * 지정하지 않을 경우 클래스명의 첫 글자를 소문자로 바꾼 이름이 기본값으로 사용됩니다.
     * </pre>
     *
     * @param menu 요청 파라미터가 바인딩된 MenuDTO 객체
     * @return 검색 결과를 출력할 뷰의 이름
     */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {

        System.out.println(menu);

        return "first/searchResult";
    }

    /* ==================== 1-4. HttpSession ==================== */

    /**
     * <pre>
     * HttpSession 및 @SessionAttributes 테스트 페이지로 이동합니다.
     * </pre>
     */
    @GetMapping("login")
    public void login() {
    }

    /**
     * <pre>
     * 서블릿의 표준 HttpSession 객체를 매개변수로 받아 세션을 관리하는 메소드입니다.
     * session.setAttribute()를 통해 세션에 값을 저장할 수 있습니다.
     * </pre>
     *
     * @param session 현재 요청과 관련된 HttpSession 객체
     * @param id      로그인 요청 아이디
     * @return 로그인 결과를 출력할 뷰의 이름
     */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id) {

        session.setAttribute("id", id);

        return "first/loginResult";
    }

    /**
     * <pre>
     * HttpSession 객체를 이용하여 세션을 무효화(로그아웃)하는 메소드입니다.
     * session.invalidate()를 호출하면 세션에 저장된 모든 데이터가 삭제됩니다.
     * </pre>
     *
     * @param session 현재 요청과 관련된 HttpSession 객체
     * @return 로그인 결과를 출력할 뷰의 이름 (로그아웃 후 이동)
     */
    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {

        session.invalidate();

        return "first/loginResult";
    }

    /**
     * <pre>
     * 클래스 레벨에 @SessionAttributes("id")를 선언하여 'id'라는 이름의 Model 속성을 세션에 저장하는 방식입니다.
     * Model에 속성을 추가하면 자동으로 세션에도 저장됩니다.
     * </pre>
     *
     * @param model 뷰에 전달할 데이터를 담는 객체 (여기서는 세션에도 저장됨)
     * @param id    로그인 요청 아이디
     * @return 로그인 결과를 출력할 뷰의 이름
     */
    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {

        model.addAttribute("id", id);

        return "first/loginResult";
    }

    /**
     * <pre>
     * @SessionAttributes로 등록된 세션 속성을 삭제(로그아웃)하는 메소드입니다.
     * SessionStatus 객체의 setComplete() 메소드를 호출하여 현재 컨트롤러 세션을 완료 처리합니다.
     * </pre>
     *
     * @param sessionStatus 세션 상태를 관리하는 객체
     * @return 로그인 결과를 출력할 뷰의 이름 (로그아웃 후 이동)
     */
    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "first/loginResult";
    }

    /* ==================== 1-5. @RequestBody ==================== */

    /**
     * <pre>
     * @RequestBody 어노테이션 테스트 페이지로 이동합니다.
     * </pre>
     */
    @GetMapping("body")
    public void body() {
    }

    /**
     * <pre>
     * &#64;RequestBody 어노테이션을 이용하여 HTTP 요청 본문(Body)을 그대로 전달받는 메소드입니다.
     * 주로 JSON이나 XML 데이터를 처리할 때 사용되지만, 여기서는 일반 폼 데이터의 바디 내용을 문자열로 확인해봅니다.
     * @RequestHeader를 통해 헤더 정보를, @CookieValue를 통해 쿠키 정보를 가져올 수도 있습니다.
     * </pre>
     *
     * @param body        HTTP 요청 본문 내용
     * @param contentType 요청의 Content-Type 헤더
     * @param sessionId   JSESSIONID 쿠키 값 (선택적)
     * @return 결과 확인 페이지 뷰의 이름
     */
    @PostMapping("body")
    public String bodyTest(@RequestBody String body,
            @RequestHeader("content-type") String contentType,
            @CookieValue(value = "JSESSIONID", required = false) String sessionId) {

        System.out.println(contentType);
        System.out.println(sessionId);
        System.out.println(body);
        System.out.println(URLDecoder.decode(body, StandardCharsets.UTF_8));

        return "first/bodyResult";
    }
}
