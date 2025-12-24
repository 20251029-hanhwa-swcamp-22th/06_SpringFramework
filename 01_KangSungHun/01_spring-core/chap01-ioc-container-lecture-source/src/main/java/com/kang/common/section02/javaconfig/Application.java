package com.kang.common.section02.javaconfig;

import com.kang.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);

        MemberDTO member = context.getBean("member2",MemberDTO.class);
        System.out.println(member);
    }
}
