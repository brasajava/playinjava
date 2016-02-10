package com.brasajava.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Address{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String country;
	private String state;
	private String city;
	private String town;
	private String neighborhood;
	private String street;
	private String number;
	private String note;

	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getTown() {
		return town;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
	public String getNote(){
		return note;
	}

	@Override
	public String toString() {
		return "AddressImpl [country=" + country + ", state=" + state + ", city=" + city + ", town=" + town
				+ ", neighborhood=" + neighborhood + ", street=" + street + ", number=" + number + ", note=" + note
				+ "]";
	}
}
