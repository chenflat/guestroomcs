package com.managementsystem.guestroom.service.platform;

import java.util.List;

import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.platform.ResourceType;
import com.managementsystem.ui.easyui.Tree;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 权限资源业务类
 * */
public interface ResourceService extends ServiceSupport<Resource, String> {
	/**
	 * 获取指定类型的资源数据
	 * 
	 * @param type
	 *            资源类别
	 * 
	 * */
	public List<Resource> getResourceByType(ResourceType type);

	/**
	 * 获取所有资源URL
	 * 
	 * @return URL类型的资源数据
	 * */
	public List<Resource> getUrlTypeOfResources();

	/**
	 * 获取所有权限资源
	 * 
	 * @return 所有权限资源
	 * */
	public List<Resource> getResources();

	/**
	 * 获取指定资源ID的所有资源数据
	 * 
	 * @param resourceId
	 *            资源ID
	 * @return 指定资源ID的所有资源数据
	 * */
	public List<Resource> getChildrenResource(String resourceId);

	/**
	 * 获取链接类型的资源树
	 * 
	 * @return 资源树列表
	 * */
	public List<Tree> getUrlTypeOfResourcesTree();

	/**
	 * 获取指定资源的方法列表
	 * 
	 * @param resourceId
	 *            资源ID
	 * @return 指定资源的方法列表
	 * */
	public List<Resource> getMethodsOfResource(String resourceId);
}
