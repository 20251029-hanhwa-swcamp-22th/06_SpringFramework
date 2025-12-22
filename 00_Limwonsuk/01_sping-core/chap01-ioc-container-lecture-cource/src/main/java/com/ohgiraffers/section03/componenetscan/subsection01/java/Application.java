package com.ohgiraffers.section03.componenetscan.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

/* @ComponentScan을 이용한 자동 Bean 등록 테스트 */
public class Application {
    public static void main(String[] args) {


        /* IoC 컨테이너 객체가 만들어 지면서
        *  com.ohhgiraffes 패키지 내부의 모든 @Component 어노테이션을 찾아
        * 자동으로 Bean 등록 */
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigurationContext.class);
        // 어노테이션이용한ioc conrtainer

        // 등록된 모든 Bean의 이름을 조회하여 출력
        String[] bearNames = context.getBeanDefinitionNames();
        for(String beanName : bearNames){
            System.out.println("beanName = " + beanName);
        }
        MemberDAO dao =context.getBean("memberDAO", MemberDAO.class);
        // IoC가 자동으로 만들어줘서 new를 안써도된다

        System.out.println(dao.selectMember(1));
        System.out.println(dao.selectMember(2));
    }
}
