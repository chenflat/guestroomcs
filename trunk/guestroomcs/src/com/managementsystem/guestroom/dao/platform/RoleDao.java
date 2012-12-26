package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 角色数据操作类
 * */
public interface RoleDao extends DaoSupport {

	/**
	 * 获取所有状态角色
	 * */
	public Set<Role> getRoles() throws DataAccessException;

	/**
	 * 获取指定状态的角色列表
	 * 
	 * @param status
	 *            状态标识
	 * */
	public Set<Role> getRolesByStatus(int status) throws DataAccessException;

	/**
	 * 获取所有活动的角色
	 * */
	public Set<Role> getEnabledRoles() throws DataAccessException;

	/**
	 * 判断是否已经存在角色名称
	 * 
	 * @param roleName
	 *            角色名称
	 * */
	public boolean isExistRoleName(String roleName) throws DataAccessException;

	/**
	 * 获取指定用户名的角色列表
	 * 
	 * @param username
	 *            用户名
	 * @return 用户角色列表
	 * */
	public Set<Role> getRolesByUserName(String username)
			throws DataAccessException;
}
