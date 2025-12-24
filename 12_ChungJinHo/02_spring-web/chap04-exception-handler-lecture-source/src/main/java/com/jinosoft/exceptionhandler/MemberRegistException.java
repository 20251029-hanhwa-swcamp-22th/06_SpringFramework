package com.jinosoft.exceptionhandler;

/**
 * 회원 가입 시 발생할 수 있는 사용자 정의 예외 클래스입니다.
 * <p>
 * 이 예외는 회원 등록 조건이 충족되지 않을 때 발생합니다.
 * </p>
 */
public class MemberRegistException extends Exception {

    /**
     * 기본 생성자
     */
    public MemberRegistException() {
    }

    /**
     * 예외 메시지를 받아 부모 클래스인 Exception에 전달하는 생성자
     *
     * @param message 예외 발생 원인 메시지
     */
    public MemberRegistException(String message) {
        super(message);
    }
}
