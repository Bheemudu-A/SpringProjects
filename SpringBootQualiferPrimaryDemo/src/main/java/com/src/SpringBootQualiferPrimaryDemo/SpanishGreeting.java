package com.src.SpringBootQualiferPrimaryDemo;

import org.springframework.stereotype.Component;

@Component
public class SpanishGreeting  implements GreetingService{

	@Override
	public void greeting() {
		
		System.out.println("!hilo it spanish");
	}

}
