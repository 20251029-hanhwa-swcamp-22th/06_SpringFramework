package com.kang.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class MemberDTO {

    private int sequence; // 회원 번호
    private String id;
    private String pwd;
    private String name;
}
