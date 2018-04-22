package com.javacodegeeks.snippets.enterprise.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericInterface <T, Id extends Serializable> {

	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(String id,Class clazz);
	
	public void delete(T entity);
	
	public List<T> findAll(String fromTable);
	
	public void deleteAll(String fromTable);

}
