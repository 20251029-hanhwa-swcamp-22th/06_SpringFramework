package org.ho.section01.autowired.subsection01.field;

import org.ho.section01.autowired.common.BookDAO;
import org.ho.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service
 * - @Component 어노테이션을 구체화한 어노테이션
 * - 서비스 계층임을 명시
 * - @ComponentScan 시 Bean으로 등록된다
 * - "bookServiceField" <- 등록된 Bean의 이름(id)
 *  */
@Service("bookServiceField")
public class BookService {

  /* 등록된 Bean 중에서 BookDAO 또는 상속 받은 Bean을 찾아 주입 */
  @Autowired // 필드 주입
  // @Qualifier("bookDAO") // 이름적어줌
  private BookDAO bookDAO;

  /* 도서 목록 전체 조회 */
  public List<BookDTO> selectAllBooks() {

    return bookDAO.selectBookList();
  }

  /* 도서 번호로 도서 조회 */
  public BookDTO searchBookBySequence(int sequence) {

    return bookDAO.selectOneBook(sequence);
  }
}
