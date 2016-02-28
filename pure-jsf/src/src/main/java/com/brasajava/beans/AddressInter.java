package com.brasajava.beans;

public interface AddressInter {
	void setId(Long id);
	Long getId();
	void setUser(User user);
	User getUser();
	void setCountry(String country);
	String getCountry();
	void setState(String state);
	String getState();
	void setCity(String city);
	String getCity();
	void setTown(String town);
	String getTown();
	void setNeighborhood(String neighborhood);
	String getNeighborhood();
	void setStreet(String street);
	String getStreet();
	void setNumber(String number);
	String getNumber();
	void setNote(String note);
	String getNote();
}
