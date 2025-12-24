package com.jinosoft.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 애플리케이션의 진입점(메인 페이지)을 연결해주는 기본 컨트롤러입니다.
 * 여러 경로(root, index, main, home)에 대해 메인 페이지를 보여주도록 설정합니다.
 * </pre>
 */
@Controller
public class MainController {

  /**
   * 메인 페이지 요청을 처리합니다.
   * "/", "/index", "/main", "/home" 중 어떤 경로로 들어와도 "main" 뷰를 반환합니다.
   *
   * @return "main" 뷰 이름 (templates/main.html)
   */
  @RequestMapping({ "/", "/index", "/main", "/home" })
  public String mainPage() {
    return "main";
  }
}
