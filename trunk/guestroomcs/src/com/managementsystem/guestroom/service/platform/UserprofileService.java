package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Userprofile;
import com.managementsystem.util.service.ServiceSupport;

public interface UserprofileService extends ServiceSupport<Userprofile, String> {

	/**
	 * 获取指定用户的资料数据
	 * 
	 * @param username
	 *            用户名
	 * @return 用户资料
	 * */
	public Set<Userprofile> getUserprofileByUsername(String username);

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
			String propertycategory);

	/**
	 * 获取用户属性数据
	 * 
	 * @param username
	 *            用户名
	 * @param propertyname
	 *            属性名称
	 * */
	public Userprofile getUserprofile(String username, String propertyname);

}
