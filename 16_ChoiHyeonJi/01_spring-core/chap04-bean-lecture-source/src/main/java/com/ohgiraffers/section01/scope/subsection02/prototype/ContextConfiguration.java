package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.*;

@Configuration
public class ContextConfiguration {
  @Bean // 반환되는 객체를 Bean으로 등록하는 어노테이션
  public Product carpBread() { // Product - common 안에 클래스 만들어놓음
    System.out.println("붕어빵 생성 시점");
    return new Bread("붕어빵", 1000, new java.util.Date());
  }

  @Bean
  @DependsOn({"carpBread", "milk", "water"})  // 나열한 빈 인스턴스가 모두 생성 된 뒤 생성 되도록
  @Lazy
  @Scope("prototype")
  public ShoppingCart cart() {
    System.out.println("쇼핑 카트 생성 시점");
    return new ShoppingCart();
  }

  @Bean
  public Product milk() {
    System.out.println("딸기우유 생성 시점");
    return new Beverage("딸기우유", 1500, 500);
    //Beverage 상속받아서 구현
  }

  @Bean
  public Product water() {
    System.out.println("물 생성 시점");
    return new Beverage("지리산암반수", 3000, 500);
  }

}