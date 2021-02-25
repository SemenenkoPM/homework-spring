package ru.itsjava.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution (* ru.itsjava.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before " + joinPoint.getSignature().getName());
    }

    @After("execution (* ru.itsjava.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Log after " + joinPoint.getSignature().getName());
    }
}
