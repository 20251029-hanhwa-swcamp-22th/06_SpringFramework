package com.ohgiraffers.section01.scope.sbsection02.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.*;

@Configuration
public class ContextConfiguration {
  @Bean
  public Product carpBread() {
    System.out.println("붕어빵 생성 시점");
    return new Bread("붕어빵", 1000, new java.util.Date());
  }

  @Bean
  @DependsOn({"carpBread", "milk", "water"})  // 나열한 빈 인스턴스가 모두 생성 된 뒤 생성 되도록
  @Lazy   // 컨테이너 동작 시점이 아니라 해당 객체 필요 시점에 인스턴스를 생성함
  @Scope("singleton") //기본값
  public ShoppingCart cart() {
    System.out.println("쇼핑 카트 생성 시점");
    return new ShoppingCart();
  }

  @Bean
  public Product milk() {
    System.out.println("딸기우유 생성 시점");
    return new Beverage("딸기우유", 1500, 500);
  }

  @Bean
  public Product water() {
    System.out.println("물 생성 시점");
    return new Beverage("지리산암반수", 3000, 500);
  }

}