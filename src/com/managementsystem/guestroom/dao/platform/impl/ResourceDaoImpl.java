package com.managementsystem.guestroom.dao.platform.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Resource> getResourceByType(ResourceType type) {
		Query query = createQuery("from Resource where resourceType=?", 0, -1,
				type);
		return query.list();
	}

	@Override
	public List<Resource> getResourceUrls() {
		return getResourceByType(ResourceType.URL);
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
