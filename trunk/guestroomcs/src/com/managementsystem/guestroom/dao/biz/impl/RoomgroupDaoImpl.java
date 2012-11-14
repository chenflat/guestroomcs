package com.managementsystem.guestroom.dao.biz.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.biz.RoomgroupDao;
import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class RoomgroupDaoImpl extends AbstractDaoSupport implements
		RoomgroupDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Roomgroup.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Roomgroup> getRoomgroups() throws DataAccessException {
		final String querySql = "from Roomgroup order by sortOrder";
		Query query = createQuery(querySql);
		return new LinkedHashSet<Roomgroup>(query.list());
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
