package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* 지정된 패키지를 componentScan 하여
        * @Component 스테레오 타입이 붙은 클래스를 Bean으로 등록
        *  */
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        BookService bookService = context.getBean(BookService.class);

        bookService.selectAllBooks().forEach(System.out::println);

        System.out.println(bookService.selectAllBooks());
        System.out.println(bookService.searchBookBySequence(1));

    }

}
