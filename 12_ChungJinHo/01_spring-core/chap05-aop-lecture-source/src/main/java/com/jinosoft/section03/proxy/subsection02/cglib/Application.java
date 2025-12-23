package com.jinosoft.section03.proxy.subsection02.cglib;

import com.jinosoft.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.Enhancer;

public class Application {
  public static void main(String[] args) {
    OhgiraffersStudent student = new OhgiraffersStudent();
    Handler handler = new Handler(student);

    /* Enhancer 클래스의 create static 메소드는 타겟 클래스의 메타정보와 핸들러를 전달하면 proxy를 생성해서 반환해준다. */
    OhgiraffersStudent proxy
        = (OhgiraffersStudent) Enhancer.create(OhgiraffersStudent.class, handler);

    proxy.study(20);
  }
}
