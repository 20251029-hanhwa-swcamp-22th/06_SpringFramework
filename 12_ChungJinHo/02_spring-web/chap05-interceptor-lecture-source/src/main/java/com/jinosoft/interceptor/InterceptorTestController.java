package com.jinosoft.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <pre>
 * 인터셉터 테스트를 위한 컨트롤러입니다.
 * 특정 경로("/stopwatch")로 요청이 들어왔을 때 수행 시간을 측정하기 위한 대상 핸들러를 포함합니다.
 * </pre>
 */
@Controller
public class InterceptorTestController {

  /**
   * <pre>
   * 인터셉터 테스트용 핸들러 메서드입니다.
   * "/stopwatch" 경로로 GET 요청이 오면 호출됩니다.
   *
   * 인터셉터의 시간 측정 기능을 확인하기 위해 {@code
   * Thread.sleep(1000)
   * }을 사용하여
   * 인위적으로 1초 동안 실행을 멈춥니다.
   * </pre>
   *
   * @return "result" 뷰 이름 (templates/result.html)
   * @throws InterruptedException Thread.sleep() 호출 시 발생할 수 있는 예외
   */
  @GetMapping("/stopwatch")
  public String stopwatch() throws InterruptedException {
    System.out.println("핸들러 메소드 호출함...");

    /* 아무 것도 하는 일이 없으면 수행시간이 0으로 나올 수 있어서, 테스트를 위해 1초(1000ms) 대기합니다. */
    Thread.sleep(1000);

    return "result";
  }
}
