package com.example.customer.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.example.customer.controller.*.*(..)) || execution(* com.example.customer.service.*.*(..)) || execution(* com.example.customer.dao.*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("Entring into  {} ", joinPoint.getSignature());
    }
	
	@After("execution(* com.example.customer.controller.*.*(..)) || execution(* com.example.customer.service.*.*(..)) || execution(* com.example.customer.dao.*.*(..))")
    public void after(JoinPoint joinPoint) {
		logger.info("Exiting into  {}  {}", joinPoint.getSignature());    }
}
