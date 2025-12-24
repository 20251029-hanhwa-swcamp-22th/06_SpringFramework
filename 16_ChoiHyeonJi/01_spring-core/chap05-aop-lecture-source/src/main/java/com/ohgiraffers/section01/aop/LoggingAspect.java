package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

// 로그 찍는 관점이라는 뜻
@Component // Bean 등록 (AOP 객체 제어 권한을 Spring에게 줌)
@Aspect // 분리된 횡단 관심사 = PointCut(삽입 시점) + Advice(공통 코드)
public class LoggingAspect {

  /* PointCut(삽입 시점) */
  @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
  public void logPointcut() {}

  //execution(*  * == 접근제어자   Service.* = 메서드 Service.*(..) .. => 매개변수 0~n개 아무거나 상관없다
  // 접근 제어자 관련 x section01 아래에 있는 모든 메서드가 대상이 되는것임(실행 시점)

  /* Advice(공통 코드)
  *  Before : 타겟의 기능이 수행되기 전 */
  @Before("LoggingAspect.logPointcut()")
  public void logBefore(JoinPoint joinPoint) {
    /* JoinPoint : 포인트컷으로 패치한 실행 시점으로
    * 메서드명, 인수 값 등의 정보를 접근할 수 있음 */
    System.out.println("===== logBefore =====");
    System.out.println("Before joinPoint.getTarget() " + joinPoint.getTarget());
    System.out.println("Before joinPoint.getSignature() " + joinPoint.getSignature());
    if(joinPoint.getArgs().length > 0){
      System.out.println("Before joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
    }
  }

  // After : 타겟의 기능이 수행된 후 (정상 수행, 예외 발생 모두 수행)
  @After("logPointcut()") // 현재 클래스에 있는 logPointcut() 지정
  public void logAfter(JoinPoint joinPoint) {
    System.out.println("@@@@@ logAfter @@@@@");
    System.out.println("After joinPoint.getTarget() " + joinPoint.getTarget());
    System.out.println("After joinPoint.getSignature() " + joinPoint.getSignature());
    if(joinPoint.getArgs().length > 0){
      System.out.println("After joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
    }
  }

  /* AfterReturning : 메서드 정상 수행 후 반환되는 시점*/
  @AfterReturning(pointcut="logPointcut()", returning="result")
  public void logAfterReturning(JoinPoint joinPoint, Object result) {
    System.out.println("After Returning result " + result);
    /* 리턴할 결과값을 변경해 줄 수 도 있다. */
    if(result != null && result instanceof Map) {
      ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
    }
  }

  /* AfterThrowing: exception 발생 후 동작 */
  @AfterThrowing(pointcut="logPointcut()", throwing="exception")
  public void logAfterThrowing(Throwable exception) {
    System.out.println("After Throwing exception " + exception);
  }

  /* Around : 핵심 기능 시작과 끝을 감싸고 동작 */
  @Around("logPointcut()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Around Before " + joinPoint.getSignature().getName());
    /* 원본 조인포인트를 실행한다. */
    Object result = joinPoint.proceed();
    System.out.println("Around After " + joinPoint.getSignature().getName());
    /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */
    return result;
  }
}
