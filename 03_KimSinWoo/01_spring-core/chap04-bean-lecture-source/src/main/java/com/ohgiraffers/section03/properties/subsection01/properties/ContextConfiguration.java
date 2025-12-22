package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
/* resources 폴더 하위 경로를 기술한다 */
@PropertySource(encoding = "UTF-8",value = "section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

  /* 치환자 문법(placeholder) 를 이용하여 properties에 저장 된 키 값을 입력하면
   * value에 해당하는 값이 가져와져서 주입 된다.
   * 양 옆에 공백이 있을 경우 값을 읽어오지 못하므로 주의!!
   * 뒤에 : 을 사용하여 key 값이 없을 경우에 대체값을 작성할 수 있다. */
  @Value("${bread.carpbread.name:팥붕어빵}")
  private String carpBreadName;

  /* 값은 여러 번 불러올 수 있다. */
//	@Value("${bread.carpbread.name:슈크림붕어빵}")
//	private String carpBreadName2;

  @Value("${bread.carpbread.price:0}")
  private int carpBreadPrice;

  @Value("${beverage.milk.name:}")
  private String milkName;

  @Value("${beverage.milk.price:0}")
  private int milkPrice;

  @Value("${beverage.milk.capacity:0}")
  private int milkCapacity;

  @Bean
  public Product carpBread() {
    return new Bread(carpBreadName, carpBreadPrice, new Date());
  }

  @Bean
  public Product milk(
      @Value("${beverage.milk.name}") String name,
      @Value("${beverage.milk.price}") int price,
      @Value("${beverage.milk.capacity}") int capacity
  ) {
    return new Beverage(name, price, capacity);
  }

  @Bean
  public Product water(
      @Value("${beverage.water.name}") String name,
      @Value("${beverage.water.price}") int price,
      @Value("${beverage.water.capacity}") int capacity
  ) {
    return new Beverage(name, price, capacity);
  }

  @Bean
  @Scope("prototype")
  public ShoppingCart cart() {
    return new ShoppingCart();
  }

}