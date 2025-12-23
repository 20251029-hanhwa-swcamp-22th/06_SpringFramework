package com.wjdqudwls.section03.componentscan.subsection01.java;


import com.wjdqudwls.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/* @Configuration을 이용한 자동 Bean 등록 테스트 */
public class Application {
  public static void main(String[] args) {

    // IoC 컨테이너 객체가 만들어 지면서
    // com.wjdqudwdls 패키지 내부에 모든 @Component 어노테이션을 찾아
    // 자동으로 bean 등록
    ApplicationContext context = new AnnotationConfigApplicationContext(configurationContext.class);

    // 등록된 모든 빈의 이름을 조회하여 출력
    String[] beanNames = context.getBeanDefinitionNames();
    for (String beanName : beanNames){
      System.out.println("beanName = " + beanName);

      MemberDAO dao = context.getBean("memberDAO", MemberDAO.class);
      System.out.println(dao.selectMember(1));
      System.out.println(dao.selectMember(2));
      System.out.println(dao.selectMember(3));
    }
  }
}
