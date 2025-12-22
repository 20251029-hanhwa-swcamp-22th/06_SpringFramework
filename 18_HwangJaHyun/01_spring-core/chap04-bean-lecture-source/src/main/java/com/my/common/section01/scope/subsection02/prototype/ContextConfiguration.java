package com.my.common.section01.scope.subsection02.prototype;

import com.my.common.Beverage;
import com.my.common.Bread;
import com.my.common.Product;
import com.my.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

public class ContextConfiguration {

  @Bean // 반환되는 객체를 bean으로 등록하는 annotation
  public Product carpBread(){
    System.out.println("붕어빵 생성 시점");
    return new Bread("붕어빵", 1000, new java.util.Date());
  }

  @Bean
  @DependsOn({"carpBread", "milk", "water"}) // 나열된 bean이 모두 생성된 뒤 생성하도록함
  @Lazy // 컨테이너 동작 시검(실행 시점)이 아닌, 해당 객체가 필요한 시점에 인스턴스 생성
  @Scope("prototype")// bean요청 시 매번 새로 생성
  public ShoppingCart cart(){
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
