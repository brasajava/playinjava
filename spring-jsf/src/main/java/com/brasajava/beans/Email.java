package com.brasajava.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Email implements Contact{
	private String description;
	private String email;
	
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String getContact() {
		return email;
	}
	@Override
	public void setContact(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Email [description=" + description + ", email=" + email + "]";
	} 
}
