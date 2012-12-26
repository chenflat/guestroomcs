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

import com.managementsystem.guestroom.domain.hibernate.Emailaddress;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class EmailAddressDaoImpl extends AbstractDaoSupport implements
		com.managementsystem.guestroom.dao.platform.EmailAddressDao {

	
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Emailaddress.class }));
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Emailaddress> getEmailAddressListByUser(User user)
			throws DataAccessException {
		final String sql="from Emailaddress where user.userId=? order by createdOnDate asc";
		Query query = createQuery(sql,-1,-1,user.getUserId());
		return new LinkedHashSet<Emailaddress>(query.list());
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
