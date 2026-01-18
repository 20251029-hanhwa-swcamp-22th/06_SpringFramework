package com.jinosoft.interceptor;

import org.springframework.stereotype.Service;

/**
 * <pre>
 * 인터셉터에서 의존성 주입(Dependency Injection)이 정상적으로 동작하는지 테스트하기 위한 서비스 클래스입니다.
 *
 * 인터셉터는 스프링 컨테이너에 의해 관리되는 빈(Bean)이므로,
 * {@code @Autowired} 또는 생성자 주입을 통해 다른 서비스 빈을 주입받아 사용할 수 있습니다.
 * 이 클래스는 그 기능을 확인하기 위해 {@link StopWatchInterceptor} 내에서 호출됩니다.
 * </pre>
 */
@Service
public class MenuService {

    /**
     * 단순히 콘솔에 로그를 출력하여 메서드가 정상적으로 호출되었는지 확인하는 메서드입니다.
     * 인터셉터의 {@code afterCompletion} 단계에서 이 메서드가 호출되는지 확인합니다.
     */
    public void method() {
        System.out.println("메소드 호출 확인");
    }
}
