package com.SD.Spring_AOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.SD.Spring_AOP.service.JobService.getAllJobs(..)) || execution(* com.SD.Spring_AOP.service.JobService.getById(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method called Before"+joinPoint.getSignature().getName());
    }
    @After("execution(* com.SD.Spring_AOP.service.JobService.Add(..))")
    public void logMethodExecuted(JoinPoint jp){LOGGER.info("Method Called "+jp.getSignature().getName());}
    @AfterReturning("execution(* com.SD.Spring_AOP.service.JobService.*(..))")
    public void logMethodReturn(JoinPoint jp){LOGGER.info("Method after called "+jp.getSignature().getName());}
    @AfterThrowing("execution(* com.SD.Spring_AOP.service.JobService.getById(..)")
    public void logMethodIssue(JoinPoint joinPoint){LOGGER.info("Method after Exception "+joinPoint.getSignature().getName());}

}
