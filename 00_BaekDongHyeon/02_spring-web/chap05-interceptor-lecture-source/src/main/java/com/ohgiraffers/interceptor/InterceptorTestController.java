package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorTestController {

  @GetMapping("/stopwatch")
  public String stopwatch(HttpServletRequest req) throws InterruptedException {
    System.out.println("Handler Method 호출 시점");
    System.out.println("startTime : " + req.getAttribute("startTime"));

    Thread.sleep(1000); // 1초 일시정지
    return "result";
  }
}
