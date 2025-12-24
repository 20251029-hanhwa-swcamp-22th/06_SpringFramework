package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {

        Student student = new OhgiraffersStudent();
        Handler handler = new Handler(student);

        /* 클래스로더, 프록시를 만들 클래스 메타 정보(인터페이스만 가능), 프록시 동작할 때 적용될 핸들러 */
        Student proxy
                = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] {Student.class}, handler);

        /* 프록시로 감싸진 인스턴스의 메소드를 호출하게 되면 핸들러에 정의한 메소드가 호출된다. */
        proxy.study(16);
    }
}
