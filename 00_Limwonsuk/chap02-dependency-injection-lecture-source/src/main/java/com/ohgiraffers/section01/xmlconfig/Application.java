package com.ohgiraffers.section01.xmlconfig;

// 응집도 = 관련된 코드만 모아두는것
// 결합도 =  한 객체 내부에서 다른 객체를 생성
//  -> 즉, 결합도가 낮을 수록 유지보수성, 유연성 이좋음
// 그래서 다형성을 활용한 결합도를 낮추는 방식이 필요

// 다형성을 익혀야 Spring이해

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
                = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().getBalance());
    }
}
