package com.my.section01.xmlconfig;

import com.my.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
  public static void main(String[] args) {
    /* XML 설정 파일을 기반으로 ApplicationContext 객체 생성 */
    /* IoC 컨테이너 생성 */
    ApplicationContext context =
      new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
    MemberDTO member = context.getBean("member", MemberDTO.class);
    System.out.println(member.getPersonalAccount());
    System.out.println(member.getPersonalAccount().getBalance());
  }
}
