package com.qew032.section01.scope.subsection01.singleton;

import com.qew032.common.Beverage;
import com.qew032.common.Bread;
import com.qew032.common.Product;
import com.qew032.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

public class ContextConfiguration {

        @Bean   // 반환되는 객체를 빈으로 등록
        public Product carpBread() {
                System.out.println("붕어빵 생성 시점");
                return  new Bread("붕어빵",1000,new java.util.Date());
        }

        @Bean
        @DependsOn({"carpBread", "milk", "water"})      // 나열된 Bean이 모두 생성된 뒤 생성하도록 함.
        @Lazy   // 컨테이너 동작 시점(실행 시점)이 아니라 해당 객체가 필요한 시점에 인스턴스 생성
        @Scope("singleton")     // 기본 값
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
