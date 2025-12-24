package com.kang.section02.javaconfig;

import com.kang.common.Account;
import com.kang.common.MemberDTO;
import com.kang.common.PersonalAccount;
import org.springframework.context.annotation.Bean;

public class ContextConfiguration {

    @Bean // 해당 메서드에서 반환되는 객체를 Bean으로 등록 -> ioc container한테 이거 생성해서 내가 필요할 때 알아서 주입해줘
    public Account accountGenerator() {



        return new PersonalAccount(20,"123-456-6643");


    }
@Bean
    public MemberDTO memberGenerator(){
        /* 생성자 주입 방식 */
//        return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());


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
