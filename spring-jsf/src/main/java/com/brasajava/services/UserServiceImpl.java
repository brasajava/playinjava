package com.brasajava.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.brasajava.beans.User;

@Service
public class UserServiceImpl implements JpaService<User> {
	@Autowired
	private JpaRepository<User, Long> repository;

	@Override
	public Page<User> findAll(Pageable pageable) {
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
	public void delete(User user) {
		repository.delete(user);
	}

	@Override
	public void delete(Iterable<? extends User> iterable) {
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
	public User findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public <S extends User> S save(S user) {
		return repository.save(user);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<User> iterable) {
		repository.deleteInBatch(iterable);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public List<User> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<User> findAll(Iterable<Long> iterable) {
		return repository.findAll(iterable);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public User getOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public <S extends User> List<S> save(Iterable<S> iterable) {
		return repository.save(iterable);
	}

	@Override
	public <S extends User> S saveAndFlush(S user) {
		return repository.saveAndFlush(user);
	}

	@Override
	public void setRepository(JpaRepository<User, Long> repository) {
		this.repository = repository;
	}
}
