package com.managementsystem.guestroom.dao.platform;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 系统设置数据操作接口类
 * 
 * @author CHENPING
 * */
public interface PortalDao extends DaoSupport {

	/**
	 * 获取指定系统信息
	 * 
	 * @param portalId
	 *            系统ID
	 * @return 系统信息
	 * */
	public Portal getPortalInfo(String portalId) throws DataAccessException;

	/**
	 * 获取默认的系统信息
	 * 
	 * @return 系统信息
	 * */
	public Portal getDefaultPortalInfo() throws DataAccessException;

	
	
	
}
