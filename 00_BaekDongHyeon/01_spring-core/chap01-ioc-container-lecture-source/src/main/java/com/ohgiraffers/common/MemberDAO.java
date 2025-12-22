package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 회원 데이터를 관리하는 DAO(Data Access Object) 클래스
 * - 실제로는 데이터베이스와 연동하지만, 학습 목적으로 Map을 사용하여 간단히 구현
 * - @Component 어노테이션으로 Spring 빈으로 자동 등록
 */
@Component  // ComponentScan 시 자동으로 빈으로 등록되는 어노테이션
public class MemberDAO {
  private final Map<Integer, MemberDTO> memberMap;

  /**
   * 생성자 - 초기 회원 데이터를 Map에 저장
   */
  public MemberDAO() {
    memberMap = new HashMap<>();
    memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
    memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
  }

  /**
   * 매개변수로 전달 받은 회원 번호를 map에서 조회 후 회원 정보를 리턴하는 메소드
   */
  public MemberDTO selectMember(int sequence) {
    return memberMap.get(sequence);
  }

  /**
   * 매개변수를 전달 받은 회원 정보를 map에 추가하고 성공 실패 여부를 boolean으로 리턴하는 메소드
   */
  public boolean insertMember(MemberDTO newMember) {
    int before = memberMap.size();
    memberMap.put(newMember.getSequence(), newMember);
    int after = memberMap.size();
    return after > before;
  }
}