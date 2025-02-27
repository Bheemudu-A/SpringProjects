package com.src.SpringSecurity.model;

public class Student {
	
	
	private int id;
	private String name;
	private String techonlogy;
	
	
	public Student(int id, String name, String techonlogy) {
		this.id = id;
		this.name=name;
		this.techonlogy=techonlogy;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechonlogy() {
		return techonlogy;
	}
	public void setTechonlogy(String techonlogy) {
		this.techonlogy = techonlogy;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", techonlogy=" + techonlogy + "]";
	}
}
