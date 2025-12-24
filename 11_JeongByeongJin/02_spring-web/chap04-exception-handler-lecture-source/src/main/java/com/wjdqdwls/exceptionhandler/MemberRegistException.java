package com.wjdqdwls.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class MemberRegistException extends Exception {
  public MemberRegistException(String message) {
    super(message);
  }
}
