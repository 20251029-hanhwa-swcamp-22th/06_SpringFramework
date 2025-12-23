package com.jinosoft.section01.autowired.subsection01.field;

import com.jinosoft.section01.autowired.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("com.jinosoft.section01");
    BookService bookService = context.getBean("bookServiceField", BookService.class);
    bookService.selectAllBooks().forEach(System.out::println);
  }
}
