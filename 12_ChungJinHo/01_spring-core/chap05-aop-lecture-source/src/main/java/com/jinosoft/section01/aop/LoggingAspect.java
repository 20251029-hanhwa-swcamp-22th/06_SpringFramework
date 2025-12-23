package com.jinosoft.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component// Bean 등록 (AOP 객체 제어 권한을 Spring에게 줌)
@Aspect // 분리된 횡단 관심사 = Pointcut (삽입 시점) + Advice(공통 코드)
public class LoggingAspect {
  @Pointcut("execution(* com.jinosoft.section01.aop.*Service.*(..))")
  public void logPointcut() {}

  /* Advice(Common code) */
  @Before("LoggingAspect.logPointcut()")
  public void logBefore(){

    System.out.println("=== logBefore ===");
  }

  @Before("LoggingAspect.logPointcut()")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println("Before joinPoint.getTarget() " + joinPoint.getTarget());
    System.out.println("Before joinPoint.getSignature() " + joinPoint.getSignature());
    if(joinPoint.getArgs().length > 0){
      System.out.println("Before joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
    }
  }

  @After("logPointcut()")
  public void logAfter(JoinPoint joinPoint) {
    System.out.println("After joinPoint.getTarget() " + joinPoint.getTarget());
    System.out.println("After joinPoint.getSignature() " + joinPoint.getSignature());
    if(joinPoint.getArgs().length > 0){
      System.out.println("After joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
    }
  }

  @AfterReturning(pointcut="logPointcut()", returning="result")
  public void logAfterReturning(JoinPoint joinPoint, Object result) {
    System.out.println("After Returning result " + result);
    /* 리턴할 결과값을 변경해 줄 수 도 있다. */
    if(result != null && result instanceof Map) {
      ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
    }
  }

  @AfterThrowing(pointcut="logPointcut()", throwing="exception")
  public void logAfterThrowing(Throwable exception) {
    System.out.println("After Throwing exception " + exception);
  }

  @Around("logPointcut()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("==== around 1111 ====");
    System.out.println("Around Before " + joinPoint.getSignature().getName());
    /* 원본 조인포인트를 실행한다. */
    Object result = joinPoint.proceed();
    System.out.println("Around After " + joinPoint.getSignature().getName());
    System.out.println("==== around 2222 ====");
    /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */
    return result;
  }





}
