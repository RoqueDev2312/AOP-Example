package com.aop.app.aspect;

import org.springframework.stereotype.Component;

import com.aop.app.dto.Greeting;
import com.aop.app.util.TimeUtils;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class AspectProcess {

	@Around("execution(public void com.aop.app.service.ServiceProcessImpl.insertToBBDD(..)) && args(gre)")
	public void insertToBBDD(ProceedingJoinPoint punto, Greeting gre) throws Throwable {
		Timestamp time1 = TimeUtils.getTimestamp();
		punto.proceed();
		Timestamp time2 = TimeUtils.getTimestamp();
		String totalTime = " Tiempo de insercion en BBDD: " + TimeUtils.calculateSecods(time2, time1) + " Segundos o "
				+ TimeUtils.calculateMilliseconds(time2, time1) + " Milisegundos";
		
		System.out.println("Mensaje a procesar desde AOP: "+gre.getContent() +" TRAZA: "+totalTime);
		
	}

}
