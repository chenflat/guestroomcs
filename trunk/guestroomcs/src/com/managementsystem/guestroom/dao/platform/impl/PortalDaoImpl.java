package com.managementsystem.guestroom.dao.platform.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.managementsystem.guestroom.dao.platform.PortalDao;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.domain.hibernate.Portalsettings;
import com.managementsystem.util.dao.AbstractDaoSupport;

/**
 * 系统设置数据操作类
 * 
 * @author CHEN PING
 * */
@Repository
public class PortalDaoImpl extends AbstractDaoSupport implements PortalDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Portal.class, Portalsettings.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Portal getPortalInfo(String portalId) throws DataAccessException {
		String queryString = "from Portal";
		Query query = null;
		if (StringUtils.hasLength(portalId)) {
			queryString += " where portalId=?";
			query = createQuerySingleResult(queryString, portalId);
		} else {
			query = createQuerySingleResult(queryString);
		}
		return (query.list().size()) > 0 ? (Portal) query.list().get(0) : null;
	}

	@Override
	public Portal getDefaultPortalInfo() throws DataAccessException {
		return getPortalInfo("");
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
