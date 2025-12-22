package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor // 매개
public class MemberDTO {

    private int sequence;                 //회원번호
    private String name;                  //이름
    private String phone;                 //휴대폰번호
    private String email;                 //이메일
    private Account personalAccount;      //개인계좌



}