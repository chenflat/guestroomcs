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

import com.managementsystem.guestroom.dao.platform.UserprofileDao;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.domain.hibernate.Userprofile;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class UserprofileDaoImpl extends AbstractDaoSupport implements
		UserprofileDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Portal.class, Userprofile.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Userprofile> getUserprofileByUsername(String username)
			throws DataAccessException {
		final String querySql = "from Userprofile profile inner join profile.profilepropertydefinition  where profile.user.username=? order by profile.profilepropertydefinition.vieworder";
		Query query = createQuery(querySql, username);
		return new LinkedHashSet<Userprofile>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Userprofile> getUserprofileByUsername(String username,
			String propertycategory) throws DataAccessException {
		final String querySql = "from Userprofile profile inner join profile.profilepropertydefinition where profile.user.username=? and profile.profilepropertydefinition.propertycategory=? order by profile.profilepropertydefinition.vieworder";
		Query query = createQuery(querySql, username,propertycategory);
		return new LinkedHashSet<Userprofile>(query.list());
	}


	@Override
	public Userprofile getUserprofile(String username, String propertyname)
			throws DataAccessException {
		final String querySql = "from Userprofile where user.username=? and profilepropertydefinition.propertyname=?";
		return (Userprofile)executeQuerySingleResult(querySql, username,propertyname);
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
