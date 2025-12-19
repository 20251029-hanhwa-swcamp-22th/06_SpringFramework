package com.my.section01.autowired.subsection02.constructor;

import com.my.section01.autowired.common.BookDAO;
import com.my.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service : @Component의 세분화 어노테이션의 한 종류로 Service 계층에서 사용한다. */
@Service("bookServiceConstructor")
public class BookService {

  private final BookDAO bookDAO;

  /* BookDAO 타입의 빈 객체를 생성자에 자동으로 주입해준다. */
  /* 현재 클래스가 Bean으로 등록되고 생성자가 1개밖에 없다면
   * 매개변수에 자동으로 Bean을 의존성 주입함
   * */
  // @Autowired
  public BookService(BookDAO bookDAO) { //ioc가 매개변수에 BookDAOImple Bean을 주입해줌
    this.bookDAO = bookDAO;
  }

  public List<BookDTO> selectAllBooks(){

    return bookDAO.selectBookList();
  }

  public BookDTO searchBookBySequence(int sequence) {

    return bookDAO.selectOneBook(sequence);
  }

}