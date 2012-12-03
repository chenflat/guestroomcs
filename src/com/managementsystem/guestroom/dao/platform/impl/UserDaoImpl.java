/**
 * 
 */
package com.managementsystem.guestroom.dao.platform.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

	private final String GETUSERS = "from User order by username asc";
	private final String GETUSERSBYSTATUS = "from User where status=? order by username asc";

	@SuppressWarnings("unchecked")
	@Override
	public Set<User> getUsers() throws DataAccessException {
		Query query = createQuery(GETUSERS, 0, -1);
		return new LinkedHashSet<User>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<User> getUsersByStatus(int status) throws DataAccessException {
		Query query = createQuery(GETUSERSBYSTATUS, 0, -1, status);
		return new LinkedHashSet<User>(query.list());
	}

	@Override
	public boolean isExistUsername(String username) throws DataAccessException {
		final String queryString = "from User where username=?";
		Query query = createQuery(queryString, username);
		@SuppressWarnings("unchecked")
		List<User> users = new ArrayList<User>(query.list());
		return users.size() > 0;
	}

	@Override
	public User getUserByName(String username) throws DataAccessException {
		final String queryString = "from User where username=?";
		return (User) executeQuerySingleResult(queryString, username);
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
