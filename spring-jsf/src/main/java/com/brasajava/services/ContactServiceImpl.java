package com.brasajava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.brasajava.beans.Contact;

@Service
public class ContactServiceImpl implements JpaService<Contact>{
	
	@Autowired
	@Qualifier("contactRepository")
	private JpaRepository<Contact, Long> repository;

	@Override
	public void setRepository(JpaRepository<Contact, Long> repository) {
		this.repository = repository;
	}

	@Override
	public Page<Contact> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public void delete(Contact contact) {
		repository.delete(contact);
	}

	@Override
	public void delete(Iterable<? extends Contact> iterable) {
		repository.delete(iterable);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public boolean exists(Long id) {
		return repository.exists(id);
	}

	@Override
	public Contact findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public <S extends Contact> S save(S contact) {
		return repository.save(contact);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Contact> iterable) {
		repository.deleteInBatch(iterable);
	}

	@Override
	public List<Contact> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Contact> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<Contact> findAll(Iterable<Long> iterable) {
		return repository.findAll(iterable);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public Contact getOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public <S extends Contact> List<S> save(Iterable<S> iterable) {
		return repository.save(iterable);
	}

	@Override
	public <S extends Contact> S saveAndFlush(S s) {
		return repository.save(s);
	}

}
