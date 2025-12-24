package com.kang.section01.autowired.subsection02.constructor;

import com.kang.section01.autowired.common.BookDAO;
import com.kang.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        /* @Service : @Component의 세분화 어노테이션의 한 종류로 Service 계층에서 사용한다. */
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceField", BookService.class);

        /* 전체 도서 목록 조회 후 출력 확인 */
        bookService.selectAllBooks().forEach(System.out::println);

        /* 도서번호로 검색 후 출력 확인*/
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));


        /* BookDAO 타입의 빈 객체를 생성자에 자동으로 주입해준다.
         *  생성자가 1개밖에 없다면 자동으로 Bean을 의존성 주입함
         * 생성자가 1개 밖에 없다면
         * 매개 변수에 자동으로 bean 을 의존성 주입함
         * */
// @Autowired
    }

}