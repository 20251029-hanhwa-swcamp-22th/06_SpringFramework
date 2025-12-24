package com.jinosoft.section03.componetscan.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/* @ComponentScan
* - 클래스레벨로 작성하는 어노테이션
* - @Component 또는 구체화된 어노테아션을 가진 클래스를
*   지정된 패키지 내에서 찾아 모두 bean으로 등록하는 어노테이션
*
*  */


@Configuration
@ComponentScan(basePackages = "com.jinosoft")
public class ConfigurationContext {
}
