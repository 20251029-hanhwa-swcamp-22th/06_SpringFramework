package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
					= new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("=============== selectMembers ===============");
        System.out.println(memberService.selectMembers());
        System.out.println("=============== selectMember ===============");
        System.out.println(memberService.selectMember(1L));

    }
}

/*
=============== selectMembers ===============
selectMembers 메소드 실행
{1=MemberDTO(id=1, name=유관순), 2=MemberDTO(id=2, name=홍길동)}
=============== selectMember ===============
selectMember 메소드 실행
MemberDTO(id=2, name=홍길동)
*/
