package com.aop.app.service;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Service;

import com.aop.app.dto.Greeting;

@Service
public class ServiceProcessImpl  implements ServiceProcess{

	@Override
	public void methodAround(Greeting gre) {
		try {
			gre.setContent("parametrizado desde Metodo para ser tratado por el aspecto");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Error en la espera de insercion...");
		}
	}

	@Override
	public void methodBefore() {
		System.out.println("Method before ejecutandose...");
	}

	@Override
	public void methodAfter() {	
		System.out.println("Method After ejecutandose...");
	}
	
	@Override
	public void methodAfterReturning() {
		System.out.println("Method AfterReturning ejecutandose...");
	}
	
	@Override
	public void methodAfterThrowing() {
		System.out.println("Method AfterReturning ejecutandose...");
		throw new RuntimeException();
	}

}
