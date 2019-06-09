package com.aop.app.service;

import org.springframework.stereotype.Service;

import com.aop.app.dto.Greeting;

@Service
public class ServiceProcessImpl  implements ServiceProcess{

	@Override
	public void insertToBBDD(Greeting gre) {
		try {
			gre.setContent("parametrizado desde Metodo para ser tratado por el aspecto");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Error en la espera de insercion...");
		}
	}

	@Override
	public void methodBefore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodAfter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodAfterThrowing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodAfterReturning() {
		// TODO Auto-generated method stub
		
	}
	
	public void aspectCall() {
		System.out.println("Applicando asvices para el primer tiempo");
	}
	
	public void myMethod() {
		System.out.println("Ente es un metodo extra");
	}
	
}
