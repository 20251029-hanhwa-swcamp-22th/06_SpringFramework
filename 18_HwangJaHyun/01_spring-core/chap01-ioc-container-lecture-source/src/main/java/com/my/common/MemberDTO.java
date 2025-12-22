package com.my.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class MemberDTO {

  private int sequence;
  private String id;
  private String pwd;
  private String name;
}
