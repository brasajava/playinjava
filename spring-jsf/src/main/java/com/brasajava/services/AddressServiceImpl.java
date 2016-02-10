package com.brasajava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.brasajava.beans.Address;

@Service
public class AddressServiceImpl implements JpaService<Address>{
	
	@Autowired
	@Qualifier("addressRepository")
	private JpaRepository<Address, Long> repository;

	@Override
	public void setRepository(JpaRepository<Address, Long> repository) {
		this.repository = repository;
	}

	@Override
	public Page<Address> findAll(Pageable pageable) {
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
	public void delete(Address address) {
		repository.delete(address);
	}

	@Override
	public void delete(Iterable<? extends Address> iterable) {
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
	public Address findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public <S extends Address> S save(S address) {
		return repository.save(address);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<Address> iterable) {
		repository.deleteInBatch(iterable);
	}

	@Override
	public List<Address> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Address> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<Address> findAll(Iterable<Long> iterable) {
		return repository.findAll(iterable);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public Address getOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public <S extends Address> List<S> save(Iterable<S> iterable) {
		return repository.save(iterable);
	}

	@Override
	public <S extends Address> S saveAndFlush(S s) {
		return repository.save(s);
	}

}
