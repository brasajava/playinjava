package com.brasajava.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class AddressImpl implements Address{
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
	@OneToOne
	private User user;

	@Override
	public void setId(Long id){
		this.id = id;
	}
	@Override
	public Long getId(){
		return id;
	}
	@Override
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String getCountry() {
		return country;
	}
	@Override
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String getState() {
		return state;
	}
	@Override
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String getCity() {
		return city;
	}
	@Override
	public void setTown(String town) {
		this.town = town;
	}
	@Override
	public String getTown() {
		return town;
	}
	@Override
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	@Override
	public String getNeighborhood() {
		return neighborhood;
	}
	@Override
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String getStreet() {
		return street;
	}
	@Override
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String getNumber() {
		return number;
	}
	@Override
	public void setNote(String note){
		this.note = note;
	}
	@Override
	public String getNote(){
		return note;
	}
	@Override
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public User getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "AddressImpl [country=" + country + ", state=" + state + ", city=" + city + ", town=" + town
				+ ", neighborhood=" + neighborhood + ", street=" + street + ", number=" + number + ", note=" + note
				+ "]";
	}	
}
