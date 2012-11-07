package com.managementsystem.guestroom.dao.platform;

import java.util.List;

import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.platform.ResourceType;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 资源数据操作类
 * */
public interface ResourceDao extends DaoSupport {

	/**
	 * 获取指定类型的资源数据
	 * @param type 资源类别
	 * */
	public List<Resource> getResourceByType(ResourceType type);

	/**
	 * 获取所有资源URL
	 * */
	public List<Resource> getResourceUrls();
	
	
}
