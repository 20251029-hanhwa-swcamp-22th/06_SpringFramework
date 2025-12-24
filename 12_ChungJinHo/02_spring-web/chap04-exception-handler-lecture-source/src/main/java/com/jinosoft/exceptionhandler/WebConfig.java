package com.jinosoft.exceptionhandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

/**
 * 웹 관련 설정을 담당하는 클래스입니다.
 * <p>
 * SimpleMappingExceptionResolver를 빈으로 등록하여 예외 처리를 설정합니다.
 * </p>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * SimpleMappingExceptionResolver를 빈으로 등록합니다.
     *
     * @return 설정된 SimpleMappingExceptionResolver 객체
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties exceptionMappings = new Properties();
        // 예외 타입별로 뷰 이름을 매핑
        exceptionMappings.put("java.lang.Exception", "error/default"); // error -> error/default 로 수정 (구조상)
        exceptionMappings.put("java.lang.RuntimeException", "error/default");

        resolver.setExceptionMappings(exceptionMappings);
        resolver.setDefaultErrorView("error/default"); // 기본 에러 뷰
        resolver.setExceptionAttribute("exception"); // 뷰에 전달할 예외 객체의 이름
        return resolver;
    }
}
