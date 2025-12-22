package com.my.section03.conmponentscan.subsection01.java;

import com.my.common.MemberDAO;
import com.my.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* @ComponentScan을 이용한 자동 bean 등록 테스트 */
public class Application {
  public static void main(String[] args) {
    // IoC컨테이너 객체가 만들어 지면서
    // com.my 패키지 내부의 모든 @Conponent 어노테이션을 찾아
    // 자동으로 Bean 등록
    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);
    
    // 등록된 모든 빈의 이름을 조회하여 출력
    String[] beanNames = context.getBeanDefinitionNames();
    for(String beanName : beanNames){
      System.out.println("beanName = " + beanName);
    }
    MemberDAO dao = context.getBean("memberDAO", MemberDAO.class);
    System.out.println(dao.selectMember(1));
    System.out.println(dao.selectMember(2));
  }
}
