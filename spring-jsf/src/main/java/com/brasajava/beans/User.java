package com.brasajava.beans;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User implements Person{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String lastname;
	private LocalDate birthday;
	private String docType;
	private String docNumber;
	private LocalDate startDate;
	private Boolean active;
	private String loginName;
	private String password;
	private BigDecimal balance;
	private int level;
	
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
	public Boolean isActive() {
		return active;
	}
	@Override
	public void setActive(Boolean active) {
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
		return "Client [id=" + id + ", name=" + name + ", lastname=" + lastname + ", birthday=" + birthday
				+ ", docType=" + docType + ", docNumber=" + docNumber + ", startDate=" + startDate + ", active="
				+ active + ", loginName=" + loginName + ", password=" + password + ", balance=" + balance + "]";
	}
}