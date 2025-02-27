package com.src.SpringBootQualiferPrimaryDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements CommandLineRunner{

	
	GreetingService greetingService;
	
	@Autowired //constructor injectionS
	public AppStartupRunner(@Qualifier("spanishGreeting") GreetingService greetingService) {
		this.greetingService  = greetingService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		greetingService.greeting();
	}

}
