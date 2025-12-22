package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MemberDTO {
  private int sequence;   // 회원 번호
  private String id;      // 회원 아이디
  private String pwd;     // 회원 비밀번호
  private String name;    // 회원 이름
}
