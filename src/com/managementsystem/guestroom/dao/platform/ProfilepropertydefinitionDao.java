package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Profilepropertydefinition;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 用户资料自定义属性数据操作接口
 * */
public interface ProfilepropertydefinitionDao extends DaoSupport {

	/**
	 * 获取属性定义列表
	 * 
	 * @return 属性列表
	 * */
	public Set<Profilepropertydefinition> getProfileproperties()
			throws DataAccessException;

	/**
	 * 获取指定属性类别的列表
	 * 
	 * @param propertycategory
	 *            属性类别名称
	 * @return 属性列表
	 * */
	public Set<Profilepropertydefinition> getProfilepropertiesByCategory(
			String propertycategory) throws DataAccessException;

}
