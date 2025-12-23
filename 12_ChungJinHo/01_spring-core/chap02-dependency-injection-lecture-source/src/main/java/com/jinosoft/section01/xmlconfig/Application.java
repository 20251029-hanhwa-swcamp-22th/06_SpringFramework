package com.jinosoft.section01.xmlconfig;

import com.jinosoft.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
  public static void  main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("section01/xmlconfig/spring-context.xml");
    MemberDTO member = context.getBean("member",MemberDTO.class);

    String balance = member.getPersonalAccount().getBalance();

    System.out.println(balance);

  }
}
