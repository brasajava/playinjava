package com.brasajava.repositories;

import java.util.List;

public interface JpaRepository<T> {
	T save(T t);
	T getOne(long id);
	List<T> findAll();
}
