package com.managementsystem.guestroom.dao.platform.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.platform.ResourceDao;
import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.platform.ResourceType;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class ResourceDaoImpl extends AbstractDaoSupport implements ResourceDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Resource.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResourceByType(ResourceType type)
			throws DataAccessException {
		final String querySql = "from Resource where status=1 and resourceType=? order by priority desc";
		Query query = createQuery(querySql, type.toString());
		return new ArrayList<Resource>(query.list());
	}

	@Override
	public List<Resource> getResourceUrls() throws DataAccessException {
		return getResourceByType(ResourceType.URL);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResources() throws DataAccessException {
		final String querySql = "from Resource where status=1 order by priority desc";
		Query query = createQuery(querySql);
		return new ArrayList<Resource>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getChildrenResource(String resourceId)
			throws DataAccessException {
		final String querySql = "from Resource where status=1 and resource.resourceId=? order by priority desc";
		Query query = createQuery(querySql, resourceId);
		return new ArrayList<Resource>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getMethodsOfResource(String resourceId)
			throws DataAccessException {
		final String querySql = "from Resource where status=1 and resourceType='method' and resource.resourceId=? order by priority desc";
		Query query = createQuery(querySql, resourceId);
		return new ArrayList<Resource>(query.list());
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
