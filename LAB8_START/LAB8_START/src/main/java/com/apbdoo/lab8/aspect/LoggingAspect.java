package com.apbdoo.lab8.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(public void saveCustomer(..))")
    public void beforeSaveCustomer() {
        log.info("before add account ...");
    }

    @After("execution(* com.apbdoo.lab8.model.*.*(..))")
    public void afterModelAdvice() {
        log.info("after lab8 model");
    }

}
