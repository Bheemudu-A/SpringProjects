package com.src.demo.SpringSession;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements SpringDemoInterface{
	
	public Laptop() {		
		super();
		System.out.println("Laptop Constructer created");
	}
	
	@Override
	public void compile() {
		System.out.println("Laptop compile mehthod");
	}

}
