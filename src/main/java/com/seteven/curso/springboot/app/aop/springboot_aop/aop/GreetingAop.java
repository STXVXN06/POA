package com.seteven.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAop {

    private Logger logger = LoggerFactory.getLogger(GreetingAop.class);

    @Before("execution(* com.seteven.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint){
        
        // Obtener nombre del metodo
        String method = joinPoint.getSignature().getName();
    
        // Obtener argumentos del metodo que vamos a interceptar
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes de: " + method + " Con los argumentos " + args);
    }


}
