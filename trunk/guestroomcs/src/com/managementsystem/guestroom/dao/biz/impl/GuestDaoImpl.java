package com.managementsystem.guestroom.dao.biz.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.biz.GuestDao;
import com.managementsystem.guestroom.domain.hibernate.Guest;
import com.managementsystem.util.dao.AbstractDaoSupport;
import com.managementsystem.util.dao.Page;

@Repository
public class GuestDaoImpl extends AbstractDaoSupport implements GuestDao {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Guest.class }));

	@Autowired
	private SessionFactory sessionFactory;

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

	@SuppressWarnings("unchecked")
	@Override
	public Set<Guest> getGuests() throws DataAccessException {
		final String sql = "from Guest order by profileid";
		Query query = createQuery(sql, 0, -1);
		return new HashSet<Guest>(query.list());
	}

	@Override
	public Page getGuests(int pageIndex, int pageSize,
			Map<String, Object> mapParams) throws DataAccessException {
		final String sql = "from Guest order by profileid";
		return pagedQuery(sql, pageIndex, pageSize, mapParams);
	}

}
