package com.Student.Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.Student.Demo.serviceimpl.StudentServiceImpl.*(..))")
    public void securityCheck() {
        System.out.println("Security: Checking access rights...");
        // Simulate security check
        boolean accessGranted = true; // This would be a dynamic check in real applications
        if (!accessGranted) {
            throw new RuntimeException("Security: Access denied.");
        }
    }
}
