package com.jinosoft.section01.xmlconfig;

import com.jinosoft.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.reflect.Member;

public class Application {
  public static void main(String[] args) {
    // MemberDTO member = new MemberDTO(1,"user01","pass01","정병진");

    /* GenericXmlApplicationContext 클래스를 사용하여 ApplicationContext를 생성한다.
     * 생성자에 XML 설정 메타 정보를 인자로 전달한다. */
    ApplicationContext context
        = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml"
        /*XML Configuration Metadata 파일 경로*/);
    
    MemberDTO member = context.getBean("member", MemberDTO.class);
    System.out.println("member = " + member);

  }
}
