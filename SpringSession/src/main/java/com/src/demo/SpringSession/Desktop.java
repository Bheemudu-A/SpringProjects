package com.src.demo.SpringSession;

public class Desktop implements SpringDemoInterface{
	
	
	
	public Desktop() {		
		super();
		System.out.println("Desktop Constructer created");
	}

	@Override
	public void compile() {
		System.out.println("Desktop compile mehthod");		
	}

}
