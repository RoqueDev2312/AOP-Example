package com.aop.app.aspect;

import org.springframework.stereotype.Component;

import com.aop.app.dto.Greeting;
import com.aop.app.util.TimeUtils;

import java.sql.Timestamp;

import org.aspectj.lang.JoinPoint;
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
		System.out.println("Tostring: "+punto.toString());
		
	}

	@Before("execution(public void com.aop.app.service.ServiceProcessImpl.methodBefore())")
	public void methodBefore(JoinPoint joinpoint) {
		System.out.println("@Before advice is executed... "+joinpoint.toString());
	}
	
	@After("execution(public void com.aop.app.service.ServiceProcessImpl.methodAfter())")
	public void methodAfter(JoinPoint joinpoint) {
		System.out.println("@After advice is executed... "+joinpoint.toString());
	}
	
	@AfterReturning("execution(public void com.aop.app.service.ServiceProcessImpl.methodAfterReturning())")
	public void methodAfterReturning(JoinPoint joinpoint) {
		System.out.println("@AfterReturning advice is executed... "+joinpoint.toString());
	}
	
	@AfterThrowing("execution(public void com.aop.app.service.ServiceProcessImpl.methodAfterThrowing())")
	public void methodAfterThrowing(JoinPoint joinpoint) {
		System.out.println("@AfterThrowing advice is executed... "+joinpoint.toString());
	}
	
}	
