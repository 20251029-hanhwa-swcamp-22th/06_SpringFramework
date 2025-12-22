package com.ohgiraffers.section03.componentscan.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* ComponentScan을 이용한 자동 Bean 등록 테스트 */
public class Application {

    public static void main(String[] args) {

        // IoC 객체가 만들어 지면서 com.ohgiraffers 패키지 내부의 모든 @Component Annotation을 찾아 자동으로 bean으로 등록을 한다
        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(ConfigurationContext.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        MemberDAO memberDAO = applicationContext.getBean("memberDAO", MemberDAO.class);
        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.selectMember(2));
    }

}
