package com.microservices.question_service.model;


public class Services {
	
	private int id;
	private String response;
	
	
	public Services(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	@Override
	public String toString() {
		return "Services [id=" + id + ", response=" + response + "]";
	}

}
