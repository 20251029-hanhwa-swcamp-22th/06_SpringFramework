package com.wjdqudwls.section01.xmlconfig;

import com.wjdqudwls.common.MemberDTO;
import org.springframework.context.ApplicationContext;
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
