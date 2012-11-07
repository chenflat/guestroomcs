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

import com.managementsystem.guestroom.dao.biz.BuildDao;
import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class BuildDaoImpl extends AbstractDaoSupport implements BuildDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Build.class }));

	private final String GETBUILDS = "from Build";
	private final String GETBUILDSBYHOTELID = "from Build where hotel.hotelId=?";

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Build> getBuilds() throws DataAccessException {
		Query query = createQuery(GETBUILDS);
		return new HashSet<Build>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Build> getBuildsByHotelId(String hotelId)
			throws DataAccessException {
		Query query = createQuery(GETBUILDSBYHOTELID, 0, -1, hotelId);
		return new HashSet<Build>(query.list());
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
