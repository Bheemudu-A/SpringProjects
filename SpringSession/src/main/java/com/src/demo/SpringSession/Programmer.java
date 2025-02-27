package com.src.demo.SpringSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Programmer {

	@Autowired
	@Qualifier("laptop")// scecifying to pick desktop for computer
	public SpringDemoInterface spInterface;
	
	public Programmer() {		
		super();
		System.out.println("Programmer Constructer created");
	}

	public SpringDemoInterface getSpInterface() {
		return spInterface;
	}

	public void setSpInterface(SpringDemoInterface spInterface) {
		this.spInterface = spInterface;
	}
	
	public void code() {
		System.out.println("code : ");
		spInterface.compile();
	}
	
	
}
