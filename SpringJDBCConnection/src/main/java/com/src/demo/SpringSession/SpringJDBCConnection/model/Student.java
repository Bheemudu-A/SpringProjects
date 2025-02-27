package com.src.demo.SpringSession.SpringJDBCConnection.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// creates bean or object only when we call this class
public class Student {

	private int rollNum =0;
	private int marks =0;
	private String name =null;
	
	
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int martks) {
		this.marks = martks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", marks=" + marks + ", name=" + name + "]";
	}
	
	
	
}
