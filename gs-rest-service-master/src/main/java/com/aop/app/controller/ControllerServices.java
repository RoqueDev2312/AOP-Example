package com.aop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aop.app.dto.Greeting;
import com.aop.app.service.ServiceProcess;

@RestController
@RequestMapping(value = "/aspects")
public class ControllerServices {
	@Autowired
	ServiceProcess service;

	@RequestMapping("/around")
	public void around() {
		service.methodAround(new Greeting(1, "desde CONtreoller"));
	}

	@RequestMapping("/before")
	public void before() {
		service.methodBefore();
	}

	@RequestMapping("/after")
	public void after() {
		service.methodAfter();
	}

	@RequestMapping("/afterReturning")
	public void afterReturning() {
		service.methodAfterReturning();
	}

	@RequestMapping("/afterThrowing")
	public void afterThrowing() {
		try {
		service.methodAfterThrowing();
		}catch (Exception e) {
			System.out.println("Error cacheado y tratadi en controller ... ");
		}
	}

}
