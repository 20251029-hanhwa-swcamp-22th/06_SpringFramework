package com.my.section02.javaconfig;

import com.my.common.Account;
import com.my.common.MemberDTO;
import com.my.common.PersonalAccount;
import org.springframework.context.annotation.Bean;

public class ContextConfiguration {
  // Bean등록 ioc컨테이너한테 나중에 생성자를 보고 알아서 창고에서 꺼내서 넣어줍니다.
  @Bean // 해당 메서드에서 반환되는 객체를 Bean으로 등록
  public Account accountGenerator(){
    return new PersonalAccount(20, "110-234-4567");
  }

  @Bean
  public MemberDTO memberGenerator() {
    /* MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
    /* return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator()); */

    MemberDTO member = new MemberDTO();
    member.setSequence(1);
    member.setName("홍길동");
    member.setPhone("010-1234-5678");
    member.setEmail("hong123@gmail.com");
    /* setter를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
    member.setPersonalAccount(accountGenerator());

    return member;
  }
  
}
