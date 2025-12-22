package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 슈퍼에 상품이 진열 되어 있다. */
        Product carpBread = applicationContext.getBean("carpBread", Product.class);
        Product milk = applicationContext.getBean("milk", Product.class);
        Product water = applicationContext.getBean("water", Product.class);

        System.out.println("쇼핑 카트 객체 꺼내기 전");
        /* 쇼핑 카트를 꺼내 상품을 담는다 */
        ShoppingCart shoppingCart = applicationContext.getBean("cart", ShoppingCart.class);
        System.out.println("쇼핑 카트 객체 꺼낸 다음");
        shoppingCart.addItem(carpBread);
        shoppingCart.addItem(milk);
        System.out.println("cart에 담긴 물품 : " + shoppingCart.getItem());

        /* 다음 손님이 와서 쇼핑 카트를 사용한다. */
        /* -> 쇼핑 카트가 Scope = "singleton" 이기 때문에
        * 이전 손님과 카트가 공유된다. */
        ShoppingCart shoppingCart2 = applicationContext.getBean("cart", ShoppingCart.class);
        shoppingCart2.addItem(water);
        System.out.println("cart2에 담긴 물품 : " + shoppingCart2.getItem());


        /* 두 카드의 hashcode를 출력해보면 동일한 것을 볼 수 있다. */
        System.out.println("cart1의 hashcode : " + shoppingCart.hashCode());
        System.out.println("cart2의 hashcode : " + shoppingCart2.hashCode());

    }
}
