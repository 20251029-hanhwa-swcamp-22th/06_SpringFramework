package com.my.section02.javaconfig;

import com.my.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class Application {
  public static void main(String[] args) {
    ApplicationContext context =new AnnotationConfigApplicationContext(ConfigurationContext.class);

    MemberDTO member = context.getBean("member2", MemberDTO.class);
    System.out.println(member);
  }
}
