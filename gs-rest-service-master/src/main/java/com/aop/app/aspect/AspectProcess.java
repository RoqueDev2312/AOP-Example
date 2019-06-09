package com.aop.app.aspect;

import org.springframework.stereotype.Component;

import com.aop.app.dto.Greeting;
import com.aop.app.util.TimeUtils;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Component
public class AspectProcess {

	@Around("execution(public void com.aop.app.service.ServiceProcessImpl.methodAround(..)) && args(gre)")
	public void methodAround(ProceedingJoinPoint punto, Greeting gre) throws Throwable {
		Timestamp time1 = TimeUtils.getTimestamp();
		punto.proceed();
		Timestamp time2 = TimeUtils.getTimestamp();
		String totalTime = " Tiempo de insercion en BBDD: " + TimeUtils.calculateSecods(time2, time1) + " Segundos o "
				+ TimeUtils.calculateMilliseconds(time2, time1) + " Milisegundos";
		
		System.out.println("Mensaje a procesar desde AOP: "+gre.getContent() +" TRAZA: "+totalTime);
		
	}

	@Before("execution(public void com.aop.app.service.ServiceProcessImpl.methodBefore())")
	public void methodBefore() {
		System.out.println("@Before advice is executed...");
	}
	
	@After("execution(public void com.aop.app.service.ServiceProcessImpl.methodAfter())")
	public void methodAfter() {
		System.out.println("@After advice is executed...");
	}
	
	@AfterReturning("execution(public void com.aop.app.service.ServiceProcessImpl.methodAfterReturning())")
	public void methodAfterReturning() {
		System.out.println("@AfterReturning advice is executed...");
	}
	
	@AfterThrowing("execution(public void com.aop.app.service.ServiceProcessImpl.methodAfterThrowing())")
	public void methodAfterThrowing() {
		System.out.println("@AfterThrowing advice is executed...");
	}
	
}	
