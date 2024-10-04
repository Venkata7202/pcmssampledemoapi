package com.Student.Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.Student.Demo.serviceimpl.StudentServiceImpl.*(..))")
    public void logBefore() {
        System.out.println("Logging: Method execution started.");
    }
}
