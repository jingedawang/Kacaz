package com.kacaz.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public interface EntityDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract <E> boolean save(E e);

	public abstract <E> void delete(E e);

	public abstract <E> E findById(java.lang.Integer id, E e);

	public abstract <E> List<E> findByExample(E e);

	public abstract <E> List findByProperty(String propertyName, Object value,
			E e);

	public abstract <E> List findAll(E e);

	public abstract <E> E merge(E e);

}