package com.managementsystem.util.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.util.dao.DaoSupport;

public abstract class AbstractServiceSupport<T extends Serializable, PK extends Serializable>
		implements ServiceSupport<T, PK> {

	private Class<T> entityClass;
	protected DaoSupport daoSupport;

	@PostConstruct
	@SuppressWarnings("unchecked")
	public void init() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public DaoSupport getDaoSupport() {
		return daoSupport;
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	@Transactional
	public T save(T model) {
		daoSupport.save(model);
		return model;
	}

	@Override
	@Transactional
	public void saveOrUpdate(T model) {
		daoSupport.saveOrUpdate(model);
	}

	@Override
	@Transactional
	public void update(T model) {
		daoSupport.update(model);
	}

	@Override
	@Transactional
	public void merge(T model) {
		daoSupport.merge(model);
	}

	@Override
	@Transactional
	public void delete(PK id) {
		daoSupport.delete(this.get(id));
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		return (T) daoSupport.get(this.entityClass, id);
	}

}
