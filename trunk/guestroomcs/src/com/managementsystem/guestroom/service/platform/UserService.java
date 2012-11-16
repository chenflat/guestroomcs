package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 用户数据操作
 * */
public interface UserService extends ServiceSupport<User, String> {

	/**
	 * 获取所有用户数据
	 * */
	public Set<User> getUsers();

	/**
	 * 获取所有活动用户
	 * */
	public Set<User> getUsersByStatus(int status);

	/**
	 * 复制用户信息，并保存为新用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return 新用户信息
	 * */
	public User copy(String userId);

}
