package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Service;

@Service
public class MenuService {

  public void method(){
    System.out.println("*** Service Method 호출 ***");
  }
}
