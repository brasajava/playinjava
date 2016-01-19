package com.brasajava;

public class SpringJsfBean {

	private String welcomMessage = "Hello World Spring";

	public void setWelcomeMessage(String message) {
		this.welcomMessage = message;
	}

	public String getWelcomeMessage() {
		return this.welcomMessage;
	}
}
