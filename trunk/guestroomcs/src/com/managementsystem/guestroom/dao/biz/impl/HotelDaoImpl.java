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

import com.managementsystem.guestroom.dao.biz.HotelDao;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class HotelDaoImpl extends AbstractDaoSupport implements HotelDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Hotel.class }));

	private final String GETHOTELS = "from Hotel";

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Hotel> getHotels() throws DataAccessException {
		Query query = createQuery(GETHOTELS);
		return new HashSet<Hotel>(query.list());
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
