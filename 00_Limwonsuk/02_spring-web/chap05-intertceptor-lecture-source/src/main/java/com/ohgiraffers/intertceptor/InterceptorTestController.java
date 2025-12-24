package com.ohgiraffers.intertceptor;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestAttributes;

@Controller
public class InterceptorTestController {
    @GetMapping("/stopwatch")
    public String stopwatch(HttpServletRequest request) throws InterruptedException {
        System.out.println("Handeler Method 호출 시킴");
        System.out.println("startTime : " + request.getAttribute("startTime"));
        Thread.sleep(1000); // 1초 일시정지
        return "result";
    }
}
