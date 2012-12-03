package com.managementsystem.guestroom.dao.platform.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.platform.ShiftworkDao;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.domain.hibernate.Shiftwork;
import com.managementsystem.util.dao.AbstractDaoSupport;
import com.managementsystem.util.dao.Page;

@Repository
public class ShiftworkDaoImpl extends AbstractDaoSupport implements
		ShiftworkDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Portal.class, Shiftwork.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Shiftwork> getShiftworksByUsername(String username)
			throws DataAccessException {
		final String querySql = "from Shiftwork where user.username=? order by createdOnDate desc";
		Query query = createQuery(querySql, username);
		return new LinkedList<Shiftwork>(query.list());
	}

	@Override
	public Page getShiftworksByUsername(int pageIndex, int pageSize,
			String username) throws DataAccessException {
		final String querySql = "from Shiftwork where user.username=? order by createdOnDate desc";
		return pagedQuery(querySql, pageIndex, pageSize, username);
	}
	
	@Override
	public Shiftwork getLastShiftworkByUsername(String username)
			throws DataAccessException {
		final String querySql = "from Shiftwork where user.username=? order by createdOnDate desc";
		return (Shiftwork)executeQuerySingleResult(querySql, username);
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
