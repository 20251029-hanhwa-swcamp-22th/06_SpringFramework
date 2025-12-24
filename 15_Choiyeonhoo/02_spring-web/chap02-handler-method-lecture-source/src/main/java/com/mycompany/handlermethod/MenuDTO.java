package com.mycompany.handlermethod;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
  private String name;
  private int price;
  private int categoryCode;
  private String orderableStatus;
}
