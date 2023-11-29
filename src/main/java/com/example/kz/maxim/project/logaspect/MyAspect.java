package com.example.kz.maxim.project.logaspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.example.kz.maxim.project.service.ServiceD.*(..))")
    protected void loggingOperation() {
    }

    @Before("execution(* com.example.kz.maxim.project.service.ServiceD.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("It runs before the method execution. " + joinPoint.getSignature().toShortString());
    }

    @After("execution(* com.example.kz.maxim.project.service..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("It is executed after method execution or after an exception " +
                "is thrown or the result is returned by the method. " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning("loggingOperation())")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("It runs after the result is returned by the method. " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing("loggingOperation())")
    public void AfterReturning(JoinPoint joinPoint) {
        log.info("It runs after an exception is thrown by the method. " + joinPoint.getSignature().toShortString());
    }



}
