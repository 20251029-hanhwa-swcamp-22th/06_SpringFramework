package com.jinosoft.section02.javaconfig;

import com.jinosoft.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* Java 기반 Spring 설정 크래스
* - @Configuration : Spring 설정 클래스임을 명시
* - @Bean
* - 메서드에서 반환되는 객체를 Spring Bean으로 등록
* - xml <bean> 태그와 같은 역할 */
//@Configuration
public class ConfigurationContext {
  @Bean(name = "member2")
  public MemberDTO getMember() {
    return new MemberDTO(1,"user01","pass01","홍길동");
  }
}
