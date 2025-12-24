package com.jinosoft.section02.javaconfig;

import com.jinosoft.common.Account;
import com.jinosoft.common.MemberDTO;
import com.jinosoft.common.PersonalAccount;
import org.springframework.context.annotation.Bean;


public class ContextConfiguration {

  @Bean  // 해당 메서드에서 반환되는 객체를 Bean 등록
  public Account accountGenerator(){
    return new PersonalAccount(20,"123-456-7890");
  }

  @Bean
  public MemberDTO memberGenerator(){
    /* constructor injection */
    /* MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
//    return new MemberDTO(1, "노무연", "010-5235-2352", "nomuheun@gmail.com", accountGenerator());

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
