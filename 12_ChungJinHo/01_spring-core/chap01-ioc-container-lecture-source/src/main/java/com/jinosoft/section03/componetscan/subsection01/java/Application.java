package com.jinosoft.section03.componetscan.subsection01.java;

import com.jinosoft.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* @ComponentScan을 이용한 자동 빈 등록 테스트 */
public class Application {
  public static  void main(String[] args) {
    // IOC 컨테이너 객체가 만들어짐녀서
    // com.jinosoft 패키지 내부의 모든 @Component 어노테이션을 찾아 자동으로 Bean 등록
    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);
    String[] bNames = context.getBeanDefinitionNames();
    for (String name : bNames) {
      System.out.println("bNames = " + name);
    }

    MemberDAO dao = context.getBean("memberDAO", MemberDAO.class);
    System.out.println(dao.selectMember(1));
    System.out.println(dao.selectMember(2));

  }
}
