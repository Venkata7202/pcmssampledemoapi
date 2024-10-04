package com.Student.Demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Around("execution(* com.Student.Demo.serviceimpl.StudentServiceImpl.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Transaction: Transaction started.");
        Object result;
        try {
            result = joinPoint.proceed();
            System.out.println("Transaction: Transaction committed.");
        } catch (Exception e) {
            System.out.println("Transaction: Transaction rolled back.");
            throw e;
        }
        return result;
    }
}
