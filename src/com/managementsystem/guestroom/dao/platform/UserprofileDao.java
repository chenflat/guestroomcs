package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Userprofile;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 用户资料数据操作接口
 * 
 * @author CHENPING
 * */
public interface UserprofileDao extends DaoSupport {

	/**
	 * 获取指定用户的资料数据
	 * 
	 * @param username
	 *            用户名
	 * @return 用户资料
	 * */
	public Set<Userprofile> getUserprofileByUsername(String username)
			throws DataAccessException;

	/**
	 * 获取指定用户的资料数据
	 * 
	 * @param username
	 *            用户名
	 * @param propertycategory
	 *            属性类别
	 * @return 用户资料
	 * */
	public Set<Userprofile> getUserprofileByUsername(String username,
			String propertycategory) throws DataAccessException;

	/**
	 * 获取用户属性数据
	 * 
	 * @param username
	 *            用户名
	 * @param propertyname
	 *            属性名称
	 * */
	public Userprofile getUserprofile(String username, String propertyname)
			throws DataAccessException;

}
