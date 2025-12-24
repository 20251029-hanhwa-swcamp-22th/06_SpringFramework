package com.jinosoft.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 핸들러(Controller) 수행 시간을 측정하기 위한 인터셉터입니다.
 * {@link HandlerInterceptor} 인터페이스를 구현하여 요청의 전처리, 후처리, 완료 처리를 담당합니다.
 * </pre>
 */
@Component
public class StopWatchInterceptor implements HandlerInterceptor {

  private final MenuService menuService;

  /**
   * 생성자를 통한 의존성 주입(Dependency Injection).
   * 인터셉터도 스프링 빈으로 등록되므로 다른 빈을 주입받아 사용할 수 있습니다.
   *
   * @param menuService 테스트용 서비스 빈
   */
  @Autowired
  public StopWatchInterceptor(MenuService menuService) {
    this.menuService = menuService;
  }

  /**
   * <pre>
   * 전처리 메서드 (Pre-handle)
   * 핸들러(Controller)가 호출되기 **전에** 실행됩니다.
   *
   * 주요 역할:
   * 1. 핸들러 실행 전 초기화 작업 (예: 시간 측정 시작)
   * 2. 요청에 대한 검증 (예: 로그인 체크, 권한 체크)
   * </pre>
   *
   * @param request  HTTP 요청 객체
   * @param response HTTP 응답 객체
   * @param handler  호출될 핸들러(Controller 메서드) 객체
   * @return true이면 다음 인터셉터나 핸들러로 진행, false이면 진행 중단(화면이 렌더링되지 않거나 직접 응답 처리 필요)
   * @throws Exception 예외 발생 시
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("preHandler 호출함...");

    // 현재 시간을 나노초 단위로 측정하여 시작 시간으로 기록합니다.
    long startTime = System.nanoTime();

    // 컨트롤러 실행 후(postHandle)에 시작 시간을 참조할 수 있도록 request 스코프에 저장합니다.
    request.setAttribute("startTime", startTime);

    /* true를 반환해야 다음 단계(컨트롤러 호출)로 진행됩니다. false를 반환하면 요청 처리가 여기서 끝납니다. */
    return true;
  }

  /**
   * <pre>
   * 후처리 메서드 (Post-handle)
   * 핸들러(Controller)가 실행된 **후**, 뷰(View)가 렌더링되기 **전에** 실행됩니다.
   *
   * 주요 역할:
   * 1. 핸들러 실행 후 결과 가공
   * 2. ModelAndView에 공통적인 모델 데이터 추가
   * </pre>
   *
   * @param request      HTTP 요청 객체
   * @param response     HTTP 응답 객체
   * @param handler      실행된 핸들러 객체
   * @param modelAndView 핸들러가 반환한 모델과 뷰 정보 (null일 수도 있음)
   * @throws Exception 예외 발생 시
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    System.out.println("postHandler 호출함...");

    // preHandle에서 저장해둔 시작 시간을 가져옵니다.
    long startTime = (long) request.getAttribute("startTime");

    // 더 이상 필요 없으므로 request 속성에서 제거합니다 (선택 사항).
    request.removeAttribute("startTime");

    // 현재 시간을 측정하여 종료 시간으로 잡고, 소요 시간을 계산합니다.
    long endTime = System.nanoTime();

    long interval = endTime - startTime;

    // 뷰(View)에서 사용할 수 있도록 모델에 소요 시간(interval)을 추가합니다.
    if (modelAndView != null) {
      modelAndView.addObject("interval", interval);
    }
  }

  /**
   * <pre>
   * 완료 처리 메서드 (After Completion)
   * 뷰(View) 렌더링까지 모두 완료된 **후에** 실행됩니다.
   *
   * 주요 역할:
   * 1. 요청 처리 중 사용한 리소스 정리 (파일 닫기 등)
   * 2. 예외 처리 (핸들러에서 발생한 예외 로그 기록 등)
   * </pre>
   *
   * @param request  HTTP 요청 객체
   * @param response HTTP 응답 객체
   * @param handler  실행된 핸들러 객체
   * @param ex       요청 처리 중 발생한 예외 (없으면 null)
   * @throws Exception 예외 발생 시
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable Exception ex) throws Exception {
    System.out.println("afterComplate 호출함...");

    // 의존성 주입받은 서비스의 메서드를 호출하여 빈 사용이 가능한지 확인합니다.
    menuService.method();
  }
}
