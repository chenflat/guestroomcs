package com.managementsystem.guestroom.dao.biz.impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.biz.GuestpreferenceDao;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class GuestpreferenceDaoImpl extends AbstractDaoSupport implements
		GuestpreferenceDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Class<?>> getTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canBeMerged(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
