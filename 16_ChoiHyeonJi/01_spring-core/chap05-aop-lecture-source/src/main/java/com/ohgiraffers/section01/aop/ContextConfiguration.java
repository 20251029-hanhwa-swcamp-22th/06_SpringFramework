package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/* proxyTargetClass = true
* - proxy(대체자) 객체 생성의 방식으로 CGLIB 방식을 사용한다.
*   -> false이면 타겟 인터페이스 이용
*   -> true 이면 타겟 클래스 이용 가능
* */

@Configuration // 이것도 설정용 bean 등록 (내부 메서드 자동 수행)
@EnableAspectJAutoProxy(proxyTargetClass = true) //활성화 함 autoproxy
public class ContextConfiguration {

}