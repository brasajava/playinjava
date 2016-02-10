package com.brasajava.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Email {
	private String description;
	private String email;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Email [description=" + description + ", email=" + email + "]";
	} 
}
