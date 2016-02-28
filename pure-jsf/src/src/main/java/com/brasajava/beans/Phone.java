package com.brasajava.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {
	private String description;
	private String phone;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Email [description=" + description + ", phone=" + phone + "]";
	} 
}
