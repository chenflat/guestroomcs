package com.managementsystem.guestroom.dao.biz.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.biz.RoomtypeDao;
import com.managementsystem.guestroom.domain.hibernate.Roomtype;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class RoomtypeDaoImpl extends AbstractDaoSupport implements RoomtypeDao {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Roomtype.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Roomtype> getRoomtypes() throws DataAccessException {
		final String sql = "from Roomtype";
		Query query = createQuery(sql);
		return new HashSet<Roomtype>(query.list());
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@Override
	public boolean canBeMerged(Object o) {
		return true;
	}

}
