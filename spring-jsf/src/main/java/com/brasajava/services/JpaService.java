package com.brasajava.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaService <T>{
	
	void setRepository(JpaRepository<T,Long> repository);
	Page<T> findAll(Pageable pageable);
	long count();
	void delete(Long id);
	void delete(T t);
	void delete(Iterable<? extends T> iterable);
	void deleteAll();
	boolean exists(Long id);
	T findOne(Long id);
	<S extends T> S save(S arg0);
	void deleteAllInBatch();
	void deleteInBatch(Iterable<T> iterable);
	List<T> findAll();
	List<T> findAll(Sort sort);
	List<T> findAll(Iterable<Long> iterable);
	void flush();
	T getOne(Long id);
	<S extends T> List<S> save(Iterable<S> iterable);
	<S extends T> S saveAndFlush(S s);


}
