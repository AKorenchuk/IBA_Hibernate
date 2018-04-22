package com.javacodegeeks.snippets.enterprise.hibernate.service.helper;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.GenericDaoHibernateImpl;

import java.util.List;

/**
 * Created by Аня on 19.04.2018.
 */
public class GenericService<T> extends Service<T> {

    private  GenericDaoHibernateImpl<T,Integer> service = new GenericDaoHibernateImpl<T,Integer>();
    private String tableName;
    private Class entityClass;

    public GenericService(String tableName,Class entityClass){
        this.tableName = tableName;
        this.entityClass = entityClass;
    }


    public void persist(T entity) {
        service.openCurrentSessionwithTransaction();
        service.persist(entity);
        service.closeCurrentSessionwithTransaction();
    }

    public void update(T entity) {
        service.openCurrentSessionwithTransaction();
        service.update(entity);
        service.closeCurrentSessionwithTransaction();
    }


    public T findById(String id) {
        service.openCurrentSession();
        T entity = service.findById(id,entityClass);
        service.closeCurrentSession();
        return entity;
    }

//    public T findByName(String name) {
//        service.openCurrentSession();
//        T entity = service.findByName(name,entityClass);
//        service.closeCurrentSession();
//        return entity;
//    }

    public void delete(String id) {
        service.openCurrentSessionwithTransaction();
        T entity = service.findById(id,entityClass);
        service.delete(entity);
        service.closeCurrentSessionwithTransaction();
    }

    public List<T> findAll() {
        service.openCurrentSession();
        List<T> books = service.findAll(tableName);
        service.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        service.openCurrentSessionwithTransaction();
        service.deleteAll(tableName);
        service.closeCurrentSessionwithTransaction();
    }
}
