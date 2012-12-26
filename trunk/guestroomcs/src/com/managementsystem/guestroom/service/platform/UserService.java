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

	/**
	 * 判断用户名是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return true or false
	 * */
	public boolean isExistUsername(String username);
	
	/**
	 * 获取用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return 用户信息
	 * */
	public User getUserByName(String username);
	
	/**
	 * 更新用户密码
	 * @param user 用户对象
	 * @param newpassword 新密码
	 * */
	public User updatePassword(User user,String newpassword);
}
