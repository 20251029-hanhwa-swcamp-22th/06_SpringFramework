package com.jinosoft.section01.scope.subsection02.prototype;

import com.jinosoft.common.Beverage;
import com.jinosoft.common.Bread;
import com.jinosoft.common.Product;
import com.jinosoft.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {
  @Bean
  @Scope("prototype") // 필요 시 마다 새로운 인스턴스를 생성해서 반환
  public ShoppingCart cart() {
    return new ShoppingCart();
  }

  @Bean
  public Product carpBread() {
    return new Bread("붕어빵", 1000, new java.util.Date());
  }

  @Bean
  public Product milk() {
    return new Beverage("딸기우유", 1500, 500);
  }

  @Bean
  public Product water() {
    return new Beverage("지리산암반수", 3000, 500);
  }
}


