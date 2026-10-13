package com.SD.Spring_AOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    @Around("execution(* com.SD.Spring_AOP.service.JobService.*(..)")
    public Object monitorTime(ProceedingJoinPoint jp)  {
        long start = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            long end = System.currentTimeMillis();
            LOGGER.info("Time Taken : "+(end-start));
        }

        return obj;
    }

}
