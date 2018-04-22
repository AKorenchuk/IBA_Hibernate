package com.javacodegeeks.snippets.enterprise.hibernate.service.helper;

import java.util.List;
/**
 * Created by Аня on 19.04.2018.
 */
public abstract class Service<T> {

    public abstract void persist(T entity);
    public abstract void update(T entity);
    public abstract T findById(String id);
    public abstract void delete(String id);
    public abstract List<T> findAll();
    public abstract void deleteAll();
   // public abstract T findByName(String name);
}
