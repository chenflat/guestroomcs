package com.managementsystem.guestroom.dao.platform.impl;

import java.util.Set;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.platform.PortalDao;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class PortalDaoImpl extends AbstractDaoSupport implements PortalDao {

	@Override
	public Portal getPortalInfo(String portalId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Portal getDefaultPortalInfo() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Class<?>> getTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canBeMerged(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
