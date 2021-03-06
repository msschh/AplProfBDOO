package com.apbdoo.hrm.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.apbdoo.hrm.service.*.*(..))")
    public void logTheApelCallBeforeExecution(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("Logger: Method " + joinPoint.getSignature() + " was called with the following arguments: ");
        for (Object arg : args) {
            log.info(arg.toString());
        }
    }
}
