package com.src.PrimaryQualifierDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Tata implements Engine{
	
	@Override
	public void bestEngine() {		
		System.out.println("Tata Car Engine is Best");
	}

}
