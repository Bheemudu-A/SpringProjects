package com.src.PrimaryQualifierDemo;

import org.springframework.stereotype.Component;

@Component
public class Suzuki implements Engine {

	@Override
	public void bestEngine() {
		System.out.println("Suzuki car engine is best");
		
	}

}
