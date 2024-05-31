package com.seteven.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcut {
  
    @Pointcut("execution(* com.seteven.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingFooAspectPoincut() {};

    @Pointcut("execution(* com.seteven.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){};

}
