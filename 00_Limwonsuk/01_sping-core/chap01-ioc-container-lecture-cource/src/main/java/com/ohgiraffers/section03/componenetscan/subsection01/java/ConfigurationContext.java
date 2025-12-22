package com.ohgiraffers.section03.componenetscan.subsection01.java;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/* @ComponentScan
* - 클래 스 레벨로 작성하는 어노테이션
* - @Component 또는 구체화된 어노테이션을 가진 클래스를
*       지정된 패키지 내에서 모두 찾아 bean으로 등록하는 어노테이션
* */

@Configurable
@ComponentScan(basePackages = "com.ohgiraffers")
public class ConfigurationContext {
}
