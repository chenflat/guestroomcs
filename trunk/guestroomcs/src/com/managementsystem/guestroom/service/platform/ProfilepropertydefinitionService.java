package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Profilepropertydefinition;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 用户资料属性定义服务层操作接口
 * 
 * @author CHENPING
 * */
public interface ProfilepropertydefinitionService extends
		ServiceSupport<Profilepropertydefinition, String> {

	/**
	 * 获取属性定义列表
	 * 
	 * @return 属性列表
	 * */
	public Set<Profilepropertydefinition> getProfileproperties();

	/**
	 * 获取指定属性类别的列表
	 * 
	 * @param propertycategory
	 *            属性类别名称
	 * @return 属性列表
	 * */
	public Set<Profilepropertydefinition> getProfilepropertiesByCategory(
			String propertycategory);

}
