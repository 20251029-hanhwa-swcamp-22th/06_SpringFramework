package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/* proxyTargetClass = true
* - proxy(대체자) 객체 생성의 방식으로 CGLUB방식을 사용
* -> true면 타겟 클래스 이용가능
* -> false면 타켓 인터페이스 이용
* */

@Configuration //   설정용 bean등록 (내부 메서드 자동 수행)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContexConfigration {
}
