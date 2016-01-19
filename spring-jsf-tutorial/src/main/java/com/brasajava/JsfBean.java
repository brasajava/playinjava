package com.brasajava;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="jsfBean")
public class JsfBean {
	private String welcomMessage = "Hello World JSF";
	
	public void setWelcomeMessage(String message){
		this.welcomMessage = message;
	}
	public String getWelcomeMessage(){
		return this.welcomMessage;
	}

}
