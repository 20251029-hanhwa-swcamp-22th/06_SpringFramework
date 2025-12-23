package com.my.handlermethod;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDTO {
	private String name;
	private int price;
	private int categoryCode;
	private String orderableStatus;
}