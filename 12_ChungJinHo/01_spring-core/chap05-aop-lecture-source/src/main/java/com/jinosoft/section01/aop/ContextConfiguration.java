package com.jinosoft.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/* proxyTargetClass = true
* - proxy 객체 생성 방식으로 CGLIB방식 사용
* -> false이면 타겟 인터페이스 이용
* -> true이면 타겟 클래스 이용 가능
*  */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {

}