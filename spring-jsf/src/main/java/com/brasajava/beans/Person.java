package com.brasajava.beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Person {

	LocalDate getBirthday();
	void setBirthday(LocalDate birthday);
	String getDocType();
	void setDocType(String docType);
	String getDocNumber();
	void setDocNumber(String docNumber);
	LocalDate getStartDate();
	void setStartDate(LocalDate startDate);
	String getLoginName();
	void setLoginName(String loginName);
	String getPassword();
	void setPassword(String password);
	BigDecimal getBalance();
	void setBalance(BigDecimal balance);
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	String getLastname();
	void setLastname(String lastname);
	Boolean isActive();
	void setActive(Boolean active);
	void setLevel(int level);
	int getLevel();

}
