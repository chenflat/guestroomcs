package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 系统用户数据类
 * 
 * @author PING.CHEN
 * */
public interface UserDao extends DaoSupport {

	/**
	 * 获取所有用户数据
	 * */
	public Set<User> getUsers();

	/**
	 * 获取所有活动用户
	 * */
	public Set<User> getUsersByStatus(int status);

}
