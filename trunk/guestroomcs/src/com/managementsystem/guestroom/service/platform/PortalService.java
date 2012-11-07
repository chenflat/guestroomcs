package com.managementsystem.guestroom.service.platform;

import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 系统信息服务类
 * */
public interface PortalService extends ServiceSupport<Portal,String> {
	
	/**
	 * 获取默认系统对象
	 * 
	 * @return 默认系统对象
	 * */
	public Portal getDefaultPortalinfo();

}
