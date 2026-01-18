package com.ohgiraffers.intertceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component // Bean 등록
public class StopWatchInerceptor implements HandlerInterceptor {

    private final MenuService service;

    // @Autowired // 생성자 1개면 생략 가능
    public StopWatchInerceptor(MenuService service){
        this.service = service;
    }

    /* 전처리 메서드
    * - 요청이 Dispatcher Servlet --(Interceptor)--> Controller
    *  넘어가는 시점에 요청을 가로챔
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========== preHandel 메서드 동작 ===========");
        long startTime = System.nanoTime();
        request.setAttribute("startTime", startTime);
        return true;
        // return true : 컨트롤러 메서드로 호출이 O
        // return false : 컨트롤러 메서드로 호출 X
    }

    /* 후처리 메서드
     * - 요청이 Controller --(Interceptor)--> Dispatcher Servlet
     *  넘어가는 시점에 요청을 가로챔
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========== postHandel 메서드 동작 ===========");
        long endTime = System.nanoTime();
        long startTime = (long)request.getAttribute("startTime");

        long interval = endTime-startTime;

        modelAndView.addObject("interval", interval);

    }

    /* 뷰 렌더링 후 동작하는 메서드 (Exception 사용 가능)
    * - View --(Interceptor)--> Dispatcher Servlet
    * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        /* Interceptor은 Spring Container 내부에 있어서
        * Bean을 의존성 주입 받아 사용할 수 있다
        * */

        System.out.println("======afterCompltion  호출시간 확인=====");
        service.method();
    }
}
