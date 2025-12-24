package com.kang.section01.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // Bean 등록 (AOP 객체 제어 권한을 Spring에게 줘야하기 때문에 Bean등록은 필수다)
@Aspect // 분리된 횡단 관심사 = Pointcut(삽입 시점) + Advice(공통 코드) 가 들어갈 것이다.
public class LoggingAspect {

    /* Pointcut(삽입 시점) */
    @Pointcut("execution(* com.kang.section01.aop.*Service.*(..))")
    // * service가 앞에 memberservice던 bookservice던 service가 들어가면 모두

    // (..) <- 이건 매개변수
    // service. <- 여기 점 뒤에 *들어가면 모든 메서드=

    public void logPointcut() {
    }

    //Advice(공통 코드)
    // Before: 타겟의 기능이 수행되기 전
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint) {


        // JoinPoint : 포인트컷으로 패치한 실행 시점으로
        // 메서드명, 인수 값 등의 정보를 접근할 수 있음.

        System.out.println("======= logBefore =======");
        System.out.println("Before joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }
    /* After : 타겟의 기능이 수행된 후 (정상 수행, 예외 발생 모두 수행) */
    @After("logPointcut()") // 현재 클래스에 있는 logPointcut() 지정
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("############################## log After ###############################");
        System.out.println("After joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }

}


