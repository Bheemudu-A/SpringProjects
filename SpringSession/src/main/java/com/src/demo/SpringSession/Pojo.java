package com.src.demo.SpringSession;

import java.beans.ConstructorProperties;

public class Pojo {
	
	private SuperPojo sp;
	int pojoNumber = 2;
	
	
	@ConstructorProperties({"sp", "age"})
	//by using @ConstructorProperties if arguments are not in order also, it will take care of it
	public Pojo(SuperPojo sp, int pojoNumber) {
		System.out.println("constructer called");
		this.sp = sp;
		this.pojoNumber = pojoNumber;
	}

	public Pojo() {
		System.out.println("Pojo constucter called");
	}
	
	public void imageViewer() {
		System.out.println("Pojo method called");
		sp = new SuperPojo();// as we are using spring we should not do these, need to inject through property
		sp.compile();
	}

	public SuperPojo getSp() {
		return sp;
	}

	public void setSp(SuperPojo sp) {
		System.out.println("setSp called");
		this.sp = sp;
	}
	
	
	
	

}
