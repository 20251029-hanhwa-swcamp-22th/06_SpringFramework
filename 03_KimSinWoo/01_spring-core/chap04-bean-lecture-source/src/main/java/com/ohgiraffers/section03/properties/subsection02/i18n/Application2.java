package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application2 {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404MessageUS = context.getMessage("error.404", null, Locale.US);
        String error500MessageUS = context.getMessage("error.500",
                new Object[]{"you", new Date()}, Locale.US);

        System.out.println("The I18N message for error.404 : " + error404MessageUS);
        System.out.println("The I18N message for error.500 : " + error500MessageUS);
    }
}
