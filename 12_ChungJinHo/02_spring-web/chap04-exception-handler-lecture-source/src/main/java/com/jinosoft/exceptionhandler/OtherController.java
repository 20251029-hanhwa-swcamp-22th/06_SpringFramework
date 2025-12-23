package com.jinosoft.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 전역 예외 처리(@ControllerAdvice)를 테스트하기 위한 컨트롤러 클래스입니다.
 * <p>
 * 이 컨트롤러에서 발생하는 예외는 GlobalExceptionHandler에서 처리됩니다.
 * </p>
 */
@Controller
public class OtherController {

    /**
     * NullPointerException을 발생시키는 테스트 메소드입니다.
     *
     * @return 뷰 이름
     */
    @GetMapping("other-controller-null")
    public String otherNullPointerExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    /**
     * MemberRegistException을 발생시키는 테스트 메소드입니다.
     *
     * @return 뷰 이름
     * @throws MemberRegistException 회원 가입 예외
     */
    @GetMapping("other-controller-user")
    public String otherUserExceptionTest() throws MemberRegistException {

        boolean check = true;
        if (check) {
            throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다!");
        }

        return "/";
    }

    /**
     * ArrayIndexOutOfBoundsException을 발생시키는 테스트 메소드입니다.
     * <p>
     * 상위 타입(Exception) 핸들러가 동작하는지 확인하기 위해 사용됩니다.
     * </p>
     *
     * @return 뷰 이름
     */
    @GetMapping("other-controller-array")
    public String otherArrayExceptionTest() {

        double[] array = new double[0];
        System.out.println(array[0]);

        return "/";
    }
}
