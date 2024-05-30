package com.seteven.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String person, String phrase) {
        System.out.println(phrase + "" + person);
        return phrase + "" + person;
    }

}
