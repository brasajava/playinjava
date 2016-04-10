package com.brasajava.beans;

import java.time.LocalDate;
import java.util.List;

public class Shopping {
	
	private User receiver;
	private List<ShopItem> items;
	private String paymentType;
	private LocalDate date;
	
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public List<ShopItem> getItems() {
		return items;
	}
	public void setItems(List<ShopItem> items) {
		this.items = items;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}	
}
