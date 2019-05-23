package com.apbdoo.lab8.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(2)
public class LoggingAspect2 {
    @Pointcut("execution(public void com.apbdoo.lab8.*.CustomerServiceImpl.saveCustomer(..))")
    private void pointCutService(){}

    @Pointcut("execution(public void com.apbdoo.lab8.*.CustomerDAO.saveCustomer(..))")
    private void pointCutDAO(){}

    @Pointcut("pointCutService() ||  pointCutDAO()")
    private void pointCutOr(){}

    @Before("pointCutOr()")
    public void beforeSaveCustomerAccountAdviceJP(JoinPoint joinPoint){
        log.info("before add account joinPoint...");
        log.info("... " + joinPoint.getSignature());
        log.info("... " + joinPoint.getArgs());
    }
}


