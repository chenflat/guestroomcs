package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 角色数据操作类
 * */
public interface RoleDao extends DaoSupport {

	/**
	 * 获取所有状态角色
	 * */
	public Set<Role> getRoles();

	/**
	 * 获取指定状态的角色列表
	 * 
	 * @param status
	 *            状态标识
	 * */
	public Set<Role> getRolesByStatus(int status);

	/**
	 * 获取所有活动的角色
	 * */
	public Set<Role> getRolesByEndabled();

}
