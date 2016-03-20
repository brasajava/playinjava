package com.brasajava.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Phone implements Contact {
	private String description;
	private String phone;
	
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
		return phone;
	}
	@Override
	public void setContact(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Email [description=" + description + ", phone=" + phone + "]";
	} 
}
