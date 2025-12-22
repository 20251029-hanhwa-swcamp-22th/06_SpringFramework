package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;
import java.lang.reflect.Member;

/* Java 기반 스프링 설정 클래스
* - @Configuration : Spring 설정 클래스임을 명시
* - @Bean
*   - 메서드 레벨에 작성
*   - 메서드에서 반환되는 객체를 Spring Bean으로 등록
*   - xml의 <bean> 태그와 같은 역할
* */
//@Configuration
public class ConfigurationContext {

    @Bean(name = "member2")
    public MemberDTO getMember() {
        return new MemberDTO(
          1, "user01","pass01","홍길동"
        );
    }

}
