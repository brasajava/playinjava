package com.brasajava.beans;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactManagerImpl implements ContactManager{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ElementCollection
	private Collection<Email> emails = new HashSet<Email>();
	@ElementCollection
	private Collection<Phone> phones = new HashSet<Phone>();

	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public Collection<Email> getEmails() {
		return emails;
	}
	@Override
	public void setEmails(Collection<Email> emails) {
		this.emails = emails;
	}
	@Override
	public Collection<Phone> getPhones() {
		return phones;
	}
	@Override
	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
}
