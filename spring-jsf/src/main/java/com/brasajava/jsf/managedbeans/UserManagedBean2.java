package com.brasajava.jsf.managedbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.brasajava.beans.Address;
import com.brasajava.beans.Contact;
import com.brasajava.beans.User;
import com.brasajava.services.JpaService;

@ManagedBean
@ViewScoped
public class UserManagedBean2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7126362164959096892L;
	
	@ManagedProperty(value="#{userServiceImpl}")
	private JpaService<User> userService;
	@ManagedProperty(value="#{addressServiceImpl}")
	private JpaService<Address> addressService;
	@ManagedProperty(value="#{contactServiceImpl}")
	private JpaService<Contact> contactService;
	private List<User> userList;
	private List<Address> addressList;
	private User user;
	private Address address;
	private Contact contact;
	
	@PostConstruct
	public void init() {
		System.out.println("UserManagedBean init");
		this.listRefresh();
	}

	@PreDestroy
	public void destroy() {
		System.out.println("UserManagedBean predestroy");
	}
	
	/*Begin Services Setter Methods*/
	public void setUserService(JpaService<User> userService) {
		this.userService = userService;
	}
	public void setAddressService(JpaService<Address> addressService) {
		this.addressService = addressService;
	}
	public void setContactService(JpaService<Contact> contactService) {
		this.contactService = contactService;
	}
	/*End Services Setter Methods*/
	

	/*Begin Object Getters and Setters*/
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/*End Object Getters and Setters*/
	
	public UserManagedBean2(){this.newObject();}
	public void update(){
		this.listRefresh();
	}
	
	public void setStringBirthday(String birthday) {
		if (birthday.length() >= 5) {
			String[] dataValues = birthday.split("/");
			user.setBirthday(LocalDate.of(Integer.parseInt(dataValues[2]), Integer.parseInt(dataValues[1]),
					Integer.parseInt(dataValues[0])));
		}else{
			//throw new IllegalArgumentException("The data Format should be in dd/MM/YYYY format");
			this.setBirthday(LocalDate.of(1982,11,15));
		}
	}
	public String getStringBirthday(){
		return  (getBirthday()!=null)?this.getBirthday().getDayOfMonth()+"/"+this.getBirthday().getMonthValue()+"/" + this.getBirthday().getYear() : null;
	}

	public void add() {	user = userService.save(user);	}
	
	
	public void addAddress(){
		address = addressService.save(address);
	}

	
	/*Begin List Setter methods*/
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Address> getAddressList(){
		return addressList;
	}
	public void setAddressList(List<Address> addressList){
		this.addressList = addressList;
	}
	/*End List Setter methods*/
	
	
	/*Begin Address Getters and Setters Method*/
	
	public void setAddressId(Long id){
		address.setId(id);
	}
	
	public Long getAddressId(){
		return address.getId();
	}
	
	public void setCountry(String country) {
		address.setCountry(country);
	}

	public String getCountry() {
		return address.getCountry();
	}

	public void setState(String state) {
		address.setState(state);
	}

	public String getState() {
		return address.getState();
	}

	public void setCity(String city) {
		address.setCity(city);
	}

	public String getCity() {
		return address.getCity();
	}

	public void setTown(String town) {
		address.setTown(town);
	}

	public String getTown() {
		return address.getTown();
	}

	public void setNeighborhood(String neighborhood) {
		address.setNeighborhood(neighborhood);
	}

	public String getNeighborhood() {
		return address.getNeighborhood();
	}

	public void setStreet(String street) {
		address.setStreet(street);
	}

	public String getStreet() {
		return address.getStreet();
	}

	public void setNumber(String number) {
		address.setNumber(number);
	}

	public String getNumber() {
		return address.getNumber();
	}
	
	public void setNote(String note){
		address.setNote(note);
	}
	
	public String getNote(){
		return address.getNote();
	}
	/*End Address Getters and Setters Method*/
	
	
	/*Begin User Getters and Setter Method*/
	public long getUserId() {
		if(user == null) System.out.println("User is null");
		return user.getId();
	}
	public void setUserId(long id) {
		user.setId(id);
	}
	public LocalDate getBirthday() {
		return user.getBirthday();
	}
	public void setBirthday(LocalDate birthday) {
		user.setBirthday(birthday);
	}
	public String getDocType() {
		return user.getDocType();
	}
	public void setDocType(String docType) {
		user.setDocType(docType);
	}
	public String getDocNumber() {
		return user.getDocNumber();
	}
	public void setDocNumber(String docNumber) {
		user.setDocNumber(docNumber);
	}
	public LocalDate getStartDate() {
		return user.getStartDate();
	}
	public void setStartDate(LocalDate startDate) {
		user.setStartDate(startDate);
	}
	public String getLoginName() {
		return user.getLoginName();
	}
	public void setLoginName(String loginName) {
		user.setLoginName(loginName);
	}
	public String getPassword() {
		return user.getPassword();
	}
	public void setPassword(String password) {
		user.setPassword(password);
	}
	public BigDecimal getBalance() {
		return user.getBalance();
	}
	public void setBalance(BigDecimal balance) {
		user.setBalance(balance);
	}
	public String getName() {
		return user.getName();
	}
	public void setName(String name) {
		user.setName(name);
	}
	public String getLastname() {
		return user.getLastname();
	}
	public void setLastname(String lastname) {
		user.setLastname(lastname);
	}
	public Boolean getActive() {
		return user.getActive();
	}
	public void setActive(boolean active) {
		user.setActive(active);
	}
	public void setLevel(int level) {
		user.setLevel(level);
	}
	public int getLevel() {
		return user.getLevel();
	}
	/*End User Getters and Setter Method*/
	
	private void listRefresh(){
		userList = userService.findAll();
		addressList = addressService.findAll();
	}
	private void newObject(){
		user = null;
		address = null;
		contact = null;
		user = new User();
		address = new Address();
		contact = new Contact();
		user.setAddress(address);
		user.setContact(contact);
	}
}
