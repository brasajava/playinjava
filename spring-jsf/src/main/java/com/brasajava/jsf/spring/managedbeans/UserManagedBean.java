package com.brasajava.jsf.spring.managedbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.brasajava.beans.Person;
import com.brasajava.beans.User;
import com.brasajava.services.JpaService;

@ManagedBean
@ApplicationScoped
public class UserManagedBean implements Person, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7126362164959096892L;
	
	@ManagedProperty(value="#{userServiceImpl}")
	private JpaService<User> userService;
	/*@ManagedProperty(value="#{addressServiceImpl}")
	private JpaService<Address> addressService;
	@ManagedProperty(value="#{contactServiceImpl}")
	private JpaService<Contact> contactService;*/
	private String name;
	private String lastname;
	private String docType;
	private String docNumber;
	private String loginName;
	private String password;
	private long id;
	private LocalDate birthday;
	private LocalDate startDate;
	private BigDecimal balance;
	private int level;
	private boolean active = false;
	private List<User> list = new ArrayList<User>();
	
	private User user;
	
	public UserManagedBean(){}
	
	private User getUser(){
		user = new User();
		user.setActive(this.active);
		user.setBalance(this.balance);
		user.setBirthday(this.birthday);
		user.setDocNumber(this.docNumber);
		user.setDocType(this.docType);
		user.setId((this.id > 0)? this.id : 0);
		user.setLastname(this.lastname);
		user.setLevel(this.level);
		user.setLoginName(this.loginName);
		user.setName(this.name);
		user.setPassword(this.password);
		user.setStartDate(LocalDate.now());
		return user;
	}
	private void setUser(User user){
		setId(user.getId());
		setName(user.getName());
		setLastname(user.getLastname());
		setBirthday(user.getBirthday());
		setDocType(user.getDocType());
		setDocNumber(user.getDocNumber());
		setLoginName(user.getLoginName());
		setPassword(user.getPassword());
		setLevel(user.getLevel());
		setBalance(user.getBalance());
		setActive(user.getActive());
		setStartDate(user.getStartDate());
	}
	private void clean(){
		setId(0);
		setName("");
		setLastname("");
		setBirthday(null);
		setDocType("");
		setDocNumber("");
		setLoginName("");
		setPassword("");
		setLevel(0);
		setBalance(new BigDecimal(0));
		setActive(false);
		setStartDate(null);
	}
	public void setStringBirthday(String birthday) {
		if (birthday.length() >= 5) {
			String[] dataValues = birthday.split("/");
			this.setBirthday(LocalDate.of(Integer.parseInt(dataValues[2]), Integer.parseInt(dataValues[1]),
					Integer.parseInt(dataValues[0])));
		}else{
			//throw new IllegalArgumentException("The data Format should be in dd/MM/YYYY format");
			this.setBirthday(LocalDate.of(1982,11,15));
		}
	}
	public String getStringBirthday(){
		return  (getBirthday()!=null)?this.getBirthday().getDayOfMonth()+"/"+this.getBirthday().getMonthValue()+"/" + this.getBirthday().getYear() : null;
	}

	public void add() {
		setUser(userService.save(getUser()));
		System.out.println("User has been saved successfully");
		System.out.println("--------------------------------------------- Begin of the User List ----------------------------------------------");
		
		for (User u : userService.findAll()) {
			System.out.println(u);
		}
		
		System.out.println("--------------------------------------------- End of the User List ----------------------------------------------");
		
		System.out.println("------------------------------------------------------------ Begin Values in the UserManagedBean properties --------------------------------------------");
		System.out.println(this.toString());
		System.out.println("------------------------------------------------------------ Begin Values in the UserManagedBean properties --------------------------------------------");
		
	}
	public void newUser(){
		System.out.println("------------------------------------- New User ----------------------------------------");
		clean();
		System.out.println(this.toString());
		System.out.println("------------------------------------- New User ----------------------------------------");
	}

	@PostConstruct
	public void init() {
		System.out.println("UserManagedBean init");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("UserManagedBean predestroy");
	}
	@Override
	public LocalDate getBirthday() {
		return birthday;
	}
	@Override
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String getDocType() {
		return docType;
	}
	@Override
	public void setDocType(String docType) {
		this.docType = docType;
	}
	@Override
	public String getDocNumber() {
		return docNumber;
	}
	@Override
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	@Override
	public LocalDate getStartDate() {
		return startDate;
	}
	@Override
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	@Override
	public String getLoginName() {
		return loginName;
	}
	@Override
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public BigDecimal getBalance() {
		return balance;
	}
	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public long getId() {
		return id;
	}
	@Override
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		System.out.println("Request for name property");
		this.name = name;
	}
	@Override
	public String getLastname() {
		return lastname;
	}
	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public Boolean getActive() {
		return active;
	}
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public int getLevel() {
		return level;
	}
	@Override
	public String toString() {
		return "UserManagedBean [name=" + name + ", lastname=" + lastname + ", docType=" + docType + ", docNumber="
				+ docNumber + ", loginName=" + loginName + ", password=" + password + ", id=" + id + ", birthday="
				+ birthday + ", startDate=" + startDate + ", balance=" + balance + ", level=" + level + ", active="
				+ active + ", user=" + user + "]";
	}
	public List<User> getList() {
		list = userService.findAll();
		/*System.out.println("----------------------------------------------- Content of List --------------------------------------------------------");
		for(User u : list){
			System.out.println(u);
		}
		System.out.println("----------------------------------------------- Content of List --------------------------------------------------------");
		User user = new User();
		user.setId(34);
		user.setName("Testt");
		user.setLastname("Last");
		list.add(user);*/
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public JpaService<User> getUserService() {
		return userService;
	}

	public void setUserService(JpaService<User> userService) {
		this.userService = userService;
	}
}
