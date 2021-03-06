package com.managementsystem.guestroom.dao.platform;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.platform.ResourceType;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 资源数据操作类
 * */
public interface ResourceDao extends DaoSupport {

	/**
	 * 获取指定类型的资源数据
	 * 
	 * @param type
	 *            资源类别
	 * 
	 * */
	public List<Resource> getResourceByType(ResourceType type)
			throws DataAccessException;

	/**
	 * 获取所有资源URL
	 * 
	 * @return URL类型的资源数据
	 * */
	public List<Resource> getResourceUrls() throws DataAccessException;

	/**
	 * 获取所有权限资源
	 * 
	 * @return 所有权限资源
	 * */
	public List<Resource> getResources() throws DataAccessException;

	/**
	 * 获取指定资源ID的所有资源数据
	 * 
	 * @param resourceId
	 *            资源ID
	 * @return 指定资源ID的所有资源数据
	 * */
	public List<Resource> getChildrenResource(String resourceId)
			throws DataAccessException;

	/**
	 * 获取指定资源的方法列表
	 * 
	 * @param resourceId
	 *            资源ID
	 * @return 指定资源的方法列表
	 * */
	public List<Resource> getMethodsOfResource(String resourceId)
			throws DataAccessException;

}
