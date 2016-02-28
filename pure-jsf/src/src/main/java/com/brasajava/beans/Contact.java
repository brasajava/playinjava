package com.brasajava.beans;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ElementCollection
	private Collection<Email> emails = new HashSet<Email>();
	@ElementCollection
	private Collection<Phone> phones = new HashSet<Phone>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Email> getEmails() {
		return emails;
	}
	public void setEmails(Collection<Email> emails) {
		this.emails = emails;
	}
	public Collection<Phone> getPhones() {
		return phones;
	}
	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
}
