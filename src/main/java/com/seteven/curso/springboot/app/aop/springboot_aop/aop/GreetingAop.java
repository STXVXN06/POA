package com.seteven.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAop {

    private Logger logger = LoggerFactory.getLogger(GreetingAop.class);

    @Before("GreetingServicePointcut.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {

        // Obtener nombre del metodo
        String method = joinPoint.getSignature().getName();

        // Obtener argumentos del metodo que vamos a interceptar
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes de: " + method + " Con los argumentos " + args);
    }

    @After("GreetingServicePointcut.greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {

        // Obtener nombre del metodo
        String method = joinPoint.getSignature().getName();

        // Obtener argumentos del metodo que vamos a interceptar
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de: " + method + " Con los argumentos " + args);
    }

    @AfterReturning("GreetingServicePointcut.greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {

        // Obtener nombre del metodo
        String method = joinPoint.getSignature().getName();

        // Obtener argumentos del metodo que vamos a interceptar
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar : " + method + " Con los argumentos " + args);
    }

    @AfterThrowing("GreetingServicePointcut.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {

        // Obtener nombre del metodo
        String method = joinPoint.getSignature().getName();

        // Obtener argumentos del metodo que vamos a interceptar
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de excecpion en: " + method + " Con los argumentos " + args);
    }

    @Around("GreetingServicePointcut.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // Obtener nombre del metodo
        String method = joinPoint.getSignature().getName();

        // Obtener argumentos del metodo que vamos a interceptar
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            logger.info("El metodo " + method + "() Con los argumentos " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() retorna el resultado: " + result);
            return result;
        } catch (Throwable e) {

            logger.error("Error en la llamada del metodo " + method + "()");

            return e;
        }

    }
}
