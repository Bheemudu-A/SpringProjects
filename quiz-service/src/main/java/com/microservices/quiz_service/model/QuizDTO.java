package com.microservices.quiz_service.model;

import org.springframework.web.bind.annotation.RequestParam;

public class QuizDTO {
	
	private String category;
	private int numQ;
	private String title;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNumQ() {
		return numQ;
	}
	public void setNumQ(int numQ) {
		this.numQ = numQ;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "QuizDTO [category=" + category + ", numQ=" + numQ + ", title=" + title + "]";
	}
	
}
