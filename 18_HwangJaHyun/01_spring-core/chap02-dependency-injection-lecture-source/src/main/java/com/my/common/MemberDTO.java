package com.my.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
* @Data : getter setter toString 전부,, 근데 요즘은 안씀
* */
@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 매개 변수 생성자(모든 필드 초기화)
public class MemberDTO {

  private int sequence;                 //회원번호
  private String name;                  //이름
  private String phone;                 //휴대폰번호
  private String email;                 //이메일
  private Account personalAccount;      //개인계좌

}
