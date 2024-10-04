package com.Student.Demo.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* com.Student.Demo.serviceimpl.StudentServiceImpl.*(..))", throwing = "ex")
    public void handleException(Exception ex) {
        System.out.println("Exception: An error occurred - " + ex.getMessage());
    }
}
