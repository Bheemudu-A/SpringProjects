package com.src.SpringBootQualiferPrimaryDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class EnglishGreeting implements GreetingService{

	@Override
	public void greeting() {
		System.out.println("Hello it's english");
		
	}

	
}
