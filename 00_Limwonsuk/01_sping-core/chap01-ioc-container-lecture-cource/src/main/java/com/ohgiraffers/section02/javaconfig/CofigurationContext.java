package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/* java기반 Spring 설정 클래스
* - @Configuration : Spring 설정 클래스 임을 명시
* - @Bean
* - 메서드 레벨에 작성
* - 메서드에서 반환되는 객체를 Spring Beam으로 등록
* - xml <bean> 태그와 같은 역할
* */


//@Configurable // 이게 있으면 가시성이 좋음
public class CofigurationContext {

   @Bean // 여기서 반환된 객체 데이터를 Bean으로 반환 하겠다
     public MemberDTO getMember(){
        return  new MemberDTO(
                1,
                "user01",
                "pass01",
                "홍킬동"
        );
    }
}
