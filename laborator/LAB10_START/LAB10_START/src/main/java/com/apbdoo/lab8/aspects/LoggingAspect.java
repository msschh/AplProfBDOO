package com.apbdoo.lab8.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(1)
public class LoggingAspect {
    @Before("execution(public void saveCustomer(..))")
    public void beforeSaveCustomerAccountAdvice(){
        log.info("before add account ...");
    }

    @After("execution(public void com.apbdoo.lab8.*.CustomerServiceImpl.saveCustomer(..))")
    public void afterSaveCustomerAdvice(){
        log.info("after add account service ...");
    }

    @After("execution(* com.apbdoo.lab8.model.*.*(..))")
    public void afterModelAdvice(){
        log.info("after lab 8 model ...");
    }




    @Before("execution(public void saveCustomer(..))")
    public void beforeSaveCustomerAccountAdviceJP(JoinPoint joinPoint){
        log.info("before add account joinPoint...");
        log.info("... " + joinPoint.getSignature());
        log.info("... " + joinPoint.getArgs());
    }
}


