package com.kang.common.section03.componentscan.subsection02.xml;

import com.kang.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
                = new GenericXmlApplicationContext("resources/section03/xmlconfig/spring-context.xml");

        MemberDAO dao = context.getBean("memberDAO", MemberDAO.class);
        System.out.println(dao.selectMember(1));
        System.out.println(dao.selectMember(2));
    }
}
