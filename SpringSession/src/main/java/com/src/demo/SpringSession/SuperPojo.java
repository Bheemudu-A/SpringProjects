package com.src.demo.SpringSession;

public class SuperPojo {
	
	private int age = 0;

	public SuperPojo() {
		System.out.println("SuperPojo constucter called");
	}
	
	public void objectGetter() {
		System.out.println("SuperPojo method called");
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
	System.out.println("setting through setter method");
		this.age = age;
	}
	
	public void compile() {
		System.out.println("Code is compiling");
	}

}
