package ru.itsjava.ExceptionProcessing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    @AfterThrowing("execution (* ru.itsjava.service.*.*(..))")
    public void exceptionProcessing(JoinPoint joinPoint){
        System.out.println("Поймал ошибку?");
    }

}
