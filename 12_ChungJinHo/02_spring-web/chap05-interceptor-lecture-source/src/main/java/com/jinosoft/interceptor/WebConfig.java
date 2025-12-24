package com.jinosoft.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * 스프링 웹 MVC 설정을 담당하는 클래스입니다.
 * {@link WebMvcConfigurer} 인터페이스를 구현하여 필요한 MVC 설정을 추가하거나 커스터마이징할 수 있습니다.
 * 여기서는 우리가 만든 인터셉터를 등록하는 역할을 합니다.
 * </pre>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final StopWatchInterceptor stopWatchInterceptor;

  /**
   * StopWatchInterceptor 빈을 생성자 주입 방식으로 주입받습니다.
   *
   * @param stopWatchInterceptor 등록할 인터셉터
   */
  @Autowired
  public WebConfig(StopWatchInterceptor stopWatchInterceptor) {
    this.stopWatchInterceptor = stopWatchInterceptor;
  }

  /**
   * <pre>
   * 인터셉터를 등록하는 메서드입니다.
   * 어떤 인터셉터를 어느 경로에 적용하고, 어느 경로에서 제외할지 설정할 수 있습니다.
   * </pre>
   *
   * @param registry 인터셉터 레지스트리
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 인터셉터 등록: registry.addInterceptor(인터셉터 객체)
    registry.addInterceptor(stopWatchInterceptor)
        // 적용할 경로 패턴 설정: "/stopwatch" 경로로 들어오는 요청에만 인터셉터를 적용
        // ("/*" 로 설정하면 모든 경로에 적용됨)
        .addPathPatterns("/stopwatch")
        // 제외할 경로 패턴 설정: 정적 리소스(css, img, js)나 에러 페이지 등은 인터셉터 동작에서 제외
        .excludePathPatterns("/css/**", "/images/**", "/js/**", "/error");
  }
}
