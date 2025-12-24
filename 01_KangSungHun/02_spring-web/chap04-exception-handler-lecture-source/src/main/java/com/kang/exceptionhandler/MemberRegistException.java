package com.kang.exceptionhandler;

public class MemberRegistException extends RuntimeException {
  public MemberRegistException(String message) {
    super(message);
  }
}
