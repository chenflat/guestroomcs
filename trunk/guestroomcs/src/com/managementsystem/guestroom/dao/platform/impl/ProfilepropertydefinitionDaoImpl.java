package com.managementsystem.guestroom.dao.platform.impl;

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

import com.managementsystem.guestroom.dao.platform.ProfilepropertydefinitionDao;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.domain.hibernate.Profilepropertydefinition;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class ProfilepropertydefinitionDaoImpl extends AbstractDaoSupport
		implements ProfilepropertydefinitionDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Portal.class,
					Profilepropertydefinition.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Profilepropertydefinition> getProfileproperties()
			throws DataAccessException {
		final String querySql = "from Profilepropertydefinition order by vieworder asc";
		Query query = createQuery(querySql);
		return new LinkedHashSet<Profilepropertydefinition>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Profilepropertydefinition> getProfilepropertiesByCategory(
			String propertycategory) throws DataAccessException {
		final String querySql = "from Profilepropertydefinition where propertycategory=? order by vieworder asc";
		Query query = createQuery(querySql, propertycategory);
		return new LinkedHashSet<Profilepropertydefinition>(query.list());
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
