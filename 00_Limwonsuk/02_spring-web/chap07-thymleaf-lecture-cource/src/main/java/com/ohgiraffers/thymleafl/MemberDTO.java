package com.ohgiraffers.thymleafl;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
    private String name;
    private int age;
    private char geder;
    private String address;

}
