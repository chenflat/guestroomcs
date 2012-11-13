package com.managementsystem.guestroom.dao.biz.impl;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.biz.FloorDao;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.util.dao.AbstractDaoSupport;
import com.managementsystem.util.dao.Page;

@Repository
public class FloorDaoImpl extends AbstractDaoSupport implements FloorDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Floor.class }));

	private final String GETFLOORBYBUILD = "from Floor where build.buildId=? order by floorNo*1";
	private final String GETFLOORS="from Floor order by floorNo*1";
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Floor> getFloorByBuild(String buildId)
			throws DataAccessException {
		Query query = createQuery(GETFLOORBYBUILD,buildId);
		return new LinkedHashSet<Floor>(query.list());
	}

	@Override
	public Page getFloors(int pageIndex, int pageSize,
			Map<String, Object> mapParams) throws DataAccessException {
		return pagedQuery(GETFLOORS, pageIndex, pageSize, mapParams);
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
