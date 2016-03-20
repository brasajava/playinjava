package com.brasajava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.brasajava.beans.AddressImpl;

@Service
public class AddressServiceImpl implements JpaService<AddressImpl>{
	
	@Autowired
	@Qualifier("addressRepository")
	private JpaRepository<AddressImpl, Long> repository;

	@Override
	public void setRepository(JpaRepository<AddressImpl, Long> repository) {
		this.repository = repository;
	}

	@Override
	public Page<AddressImpl> findAll(Pageable pageable) {
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
	public void delete(AddressImpl address) {
		repository.delete(address);
	}

	@Override
	public void delete(Iterable<? extends AddressImpl> iterable) {
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
	public AddressImpl findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public <S extends AddressImpl> S save(S address) {
		return repository.save(address);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<AddressImpl> iterable) {
		repository.deleteInBatch(iterable);
	}

	@Override
	public List<AddressImpl> findAll() {
		return repository.findAll();
	}

	@Override
	public List<AddressImpl> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<AddressImpl> findAll(Iterable<Long> iterable) {
		return repository.findAll(iterable);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public AddressImpl getOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public <S extends AddressImpl> List<S> save(Iterable<S> iterable) {
		return repository.save(iterable);
	}

	@Override
	public <S extends AddressImpl> S saveAndFlush(S s) {
		return repository.save(s);
	}

}
