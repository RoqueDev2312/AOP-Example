package com.aop.app.service;

import org.springframework.stereotype.Service;

import com.aop.app.dto.Greeting;

@Service
public class ServiceProcessImpl  implements ServiceProcess{

	@Override
	public void insertToBBDD(Greeting gre) {
		try {
			gre.setContent("parametrizado desde Metodo para ser tratado por el aspecto");
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			System.out.println("Error en la espera de insercion...");
		}
	}

}
