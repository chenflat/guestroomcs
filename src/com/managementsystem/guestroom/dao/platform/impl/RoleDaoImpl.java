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

import com.managementsystem.guestroom.dao.platform.RoleDao;
import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class RoleDaoImpl extends AbstractDaoSupport implements RoleDao {

	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Role.class }));

	private final String GETROLES = "from Role order by status asc,roleId asc";
	private final String GETROLESBYSTATUS = "from Role where status=? order by roleId asc";

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Role> getRoles() throws DataAccessException {
		Query query = createQuery(GETROLES, 0, -1);
		return new HashSet<Role>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Role> getRolesByStatus(int status) throws DataAccessException {
		Query query = createQuery(GETROLESBYSTATUS, 0, -1, status);
		return new HashSet<Role>(query.list());
	}

	@Override
	public Set<Role> getEnabledRoles() throws DataAccessException {
		return getRolesByStatus(1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExistRoleName(String roleName) throws DataAccessException {
		final String querySql = "from Role where status=1 and roleName=?";
		Query query = createQuery(querySql, roleName);
		List<Role> roles = new ArrayList<Role>(query.list());
		return (roles != null && roles.size() > 0) ? true : false;
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
