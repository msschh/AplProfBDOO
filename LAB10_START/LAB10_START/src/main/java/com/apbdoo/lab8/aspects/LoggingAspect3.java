package com.apbdoo.lab8.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
@Slf4j
public class LoggingAspect3 {
    @Around("execution(* com.apbdoo.lab8.model.Hello.get*(..))")
    public void aroundSaveCustomerAdvice(){
        log.info("around add account service ...");
    }

    @After("execution(* com.apbdoo.lab8.model.*.*(..))")
    public void afterModelAdvice(){
        log.info("after lab 8 model ...");
    }

}
