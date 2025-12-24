package com.jinosoft.section01.autowired.subsection01.field;

import com.jinosoft.section01.autowired.common.BookDAO;
import com.jinosoft.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service
* - @Component 서비스를 구체화한 어노테이션
* - 서비스 계층임을 명시
* - @ComponentScan 시 Bean으로 등록된다.
* - bookServiceField <- 등록된 Bean의 이름(id)
*  */
@Service("bookServiceField")
public class BookService {
  private final BookDAO bookDAO;

  /* BookDAO 타입의 빈 객체를 생성자에 자동으로 주입해준다. */
  @Autowired
  public BookService(BookDAO bookDAO) {
    this.bookDAO = bookDAO;
  }

  public List<BookDTO> selectAllBooks(){

    return bookDAO.selectBookList();
  }

  public BookDTO searchBookBySequence(int sequence) {

    return bookDAO.selectOneBook(sequence);
  }


}
