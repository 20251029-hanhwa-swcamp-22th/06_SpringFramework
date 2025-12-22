package com.ohgiraffers.section03.componentscan.subsection02.xml;


import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("section03/xmlconfig/spring-context.xml");

        MemberDAO memberDAO = applicationContext.getBean("memberDAO", MemberDAO.class);
        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.selectMember(2));



    }

}
