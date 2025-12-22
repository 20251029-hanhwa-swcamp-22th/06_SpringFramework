package com.ohgiraffers.section02.javaconfig;


import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ConfigurationContext.class);

        MemberDTO memberDTO = applicationContext.getBean("member2", MemberDTO.class);
        System.out.println("memberDTO = " + memberDTO);

    }

}
