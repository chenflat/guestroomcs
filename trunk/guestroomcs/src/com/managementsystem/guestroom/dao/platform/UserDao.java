package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

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
	public Set<User> getUsers() throws DataAccessException;

	/**
	 * 获取所有活动用户
	 * */
	public Set<User> getUsersByStatus(int status) throws DataAccessException;

	/**
	 * 是否存在用户名
	 * */
	public boolean isExistUsername(String username) throws DataAccessException;

	/**
	 * 获取用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return 用户信息
	 * */
	public User getUserByName(String username) throws DataAccessException;

}
