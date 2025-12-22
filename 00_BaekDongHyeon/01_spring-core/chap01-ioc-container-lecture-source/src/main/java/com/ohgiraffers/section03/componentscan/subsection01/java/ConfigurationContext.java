package com.ohgiraffers.section03.componentscan.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* @ComponentScan
* - 클래스 레벨로 작성하는 어노테이션
* - @Component 또는 구체화된 어노테이션을 가진 클래스를
*   지정된 패키지 내에서 모두 찾아 bean으로 등록하는 어노테이션
* */


@Configuration
@ComponentScan(basePackages = "com.ohgiraffers")
public class ConfigurationContext {
}
