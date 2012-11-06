package com.managementsystem.guestroom.service.platform;

import com.managementsystem.guestroom.domain.hibernate.Portal;

/**
 * 系统信息服务类
 * */
public interface PortalService {

	/**
	 * 保存系统信息
	 * 
	 * @param portal
	 *            系统对象
	 * */
	public void savePortalinfo(Portal portal);

	/**
	 * 更新系统信息
	 * 
	 * @param portal
	 *            系统对象
	 * */
	public void updatePortalinfo(Portal portal);

	/**
	 * 删除系统信息
	 * 
	 * @param portalId
	 *            系统对象ID
	 * */
	public void deletePortalinfo(String portalId);

	/**
	 * 获取指定系统ID的对象
	 * 
	 * @param portalId
	 *            系统对象ID
	 * @return 系统对象
	 * */
	public Portal getPortalinfo(String portalId);

	/**
	 * 获取默认系统对象
	 * 
	 * @return 默认系统对象
	 * */
	public Portal getDefaultPortalinfo();

}
