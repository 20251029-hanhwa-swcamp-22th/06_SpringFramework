package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component // Bean 드옥 (AOP 객체 제어 권한을 Spring에게 줌)
@Aspect // 분리된 횡단 관심사 = Pointcut(삽입 시점) + Advice(공통 코드)
public class LoggingAspect {
    /*Pointcut(삽입 시점)*/
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    // *= All , method뒤에 .. = All
    // 모든서비스에 모든 메서드가 pointcut(삽입시점)이다
    // 특정한 행동을 하기전에 끼워넣는 코드인데 재사용하는 코드임
    //
    public void logPointcut() {}


    /*Advice(공통 코드)
    * Before : 타겟의 기능이 수행되기 전 */
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){

        // JointPonint : 포인트컷으로 패치(붙이는 패치)한 실행 시점으로
        // 매서드명, 인수 값 등의 정보를 접근할 수 있음.

        System.out.println("========= LogBefore ========");

            System.out.println("Before joinPoint.getTarget() " + joinPoint.getTarget());
            System.out.println("Before joinPoint.getSignature() " + joinPoint.getSignature());
            // 메서드 선언부 = 메서드 시그니처
            if(joinPoint.getArgs().length > 0){
                System.out.println("Before joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
            }

    }
    /* After : 타겟의 기능이 수행된 후 (정상 수행, 예외 발생 모두 수행)*/
    @After("logPointcut()") // 현재 클래스에 있는 logPointcut() 지정
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("@@@@@@@@@@@@@@ logAfter @@@@@@@@@@@@@@@@@@");
        System.out.println("After joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){
            System.out.println("After joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }

    }
    /* AfterReturning : Method 정상 수행 후 반환되는 시점 */
    @AfterReturning(pointcut="logPointcut()", returning="result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("$$$$$$$$$$$$$$ AfterReturning $$$$$$$$$$$$$$$$$$");
        System.out.println("After Returning result " + result);
        /* 리턴할 결과값을 변경해 줄 수 도 있다. */
        if(result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
        }


    }
/*AfterThrowing : exception 발생 후 동작 */
    @AfterThrowing(pointcut="logPointcut()", throwing="exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("************ AfterThrowing *******************");
        System.out.println("After Throwing exception " + exception);
    }
    /* Around : 핵심기능 시작(before)과 끝(after)을 감싸고 동작 */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before " + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 실행한다.
        * - 조인포인트를 중심으로 위면 before 아래면 after */
        Object result = joinPoint.proceed();
        System.out.println("Around After " + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */
        return result;
    }
}

