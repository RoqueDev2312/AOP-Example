package com.aop.app.service;

import com.aop.app.dto.Greeting;

public interface ServiceProcess {

	public void methodAround(Greeting gre);
	
	public void methodBefore() ;
	public void methodAfter();
	public void methodAfterThrowing();
	public void methodAfterReturning();
	
}
