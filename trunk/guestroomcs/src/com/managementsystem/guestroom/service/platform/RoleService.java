package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 角色服务操作类
 * */
public interface RoleService extends ServiceSupport<Role, String> {
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
	public Set<Role> getEnabledRoles();
}
