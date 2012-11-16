package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.RoleDao;
import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.service.platform.RoleService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class RoleServiceImpl extends AbstractServiceSupport<Role, String>
		implements RoleService {

	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		setDaoSupport(roleDao);
	}

	@Transactional(readOnly = true)
	public Set<Role> getRoles() {
		return roleDao.getRoles();
	}

	@Transactional(readOnly = true)
	public Set<Role> getRolesByStatus(int status) {
		return roleDao.getRolesByStatus(status);
	}

	@Transactional(readOnly = true)
	public Set<Role> getEnabledRoles() {
		return roleDao.getEnabledRoles();
	}

}
