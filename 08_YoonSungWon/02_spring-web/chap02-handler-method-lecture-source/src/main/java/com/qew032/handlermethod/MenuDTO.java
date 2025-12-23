package com.qew032.handlermethod;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuDTO {

        private String name;
        private int price;
        private int categoryCode;
        private String orderableStatus;

}
