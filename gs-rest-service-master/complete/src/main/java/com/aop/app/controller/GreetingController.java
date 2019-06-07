package com.aop.app.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aop.app.dto.Greeting;
import com.aop.app.service.ServiceProcess;

@RestController
@RequestMapping(value = "/sendMessage")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    ServiceProcess service;
    
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	service.insertToBBDD(new Greeting(1,"desde CONtreoller"));
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
