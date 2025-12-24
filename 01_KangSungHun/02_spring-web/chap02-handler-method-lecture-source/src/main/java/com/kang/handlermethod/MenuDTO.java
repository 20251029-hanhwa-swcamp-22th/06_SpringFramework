package com.kang.handlermethod;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class menuDTO {
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;
}
