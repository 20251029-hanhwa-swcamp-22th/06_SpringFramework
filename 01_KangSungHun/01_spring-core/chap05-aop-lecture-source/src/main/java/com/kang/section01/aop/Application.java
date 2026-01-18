package com.kang.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
					= new AnnotationConfigApplicationContext("com.kang.section01.aop");

        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("=============== selectMembers ===============");
        System.out.println(memberService.selectMembers());
        System.out.println("=============== selectMember ===============");
        System.out.println(memberService.selectMember(2L));

    }
    /* AfterReturning: 메서드 정상 수행 후 반환되는 시점 */
    @AfterReturning(pointcut="logPointcut()", returning="result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result " + result);
        /* 리턴할 결과값을 변경해 줄 수 도 있다. */
        if(result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
        }
    }
    /* AfterThrowing : exception 발생 후 동작 */
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
