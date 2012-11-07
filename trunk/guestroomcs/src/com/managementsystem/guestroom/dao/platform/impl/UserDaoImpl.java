/**
 * 
 */
package com.managementsystem.guestroom.dao.platform.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.platform.UserDao;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.dao.AbstractDaoSupport;

/**
 * @author zc
 * 
 */
@Repository
public class UserDaoImpl extends AbstractDaoSupport implements UserDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { User.class }));

	@Autowired
	private SessionFactory sessionFactory;

	private final String GETUSERS = "from User";
	private final String GETUSERSBYSTATUS = "from User where status=?";

	@SuppressWarnings("unchecked")
	@Override
	public Set<User> getUsers() {
		Query query = createQuery(GETUSERS, 0, -1);
		return new HashSet<User>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<User> getUsersByStatus(int status) {
		Query query = createQuery(GETUSERSBYSTATUS, 0, -1, status);
		return new HashSet<User>(query.list());
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
		return false;
	}

}
