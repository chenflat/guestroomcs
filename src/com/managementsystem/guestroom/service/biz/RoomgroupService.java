package com.managementsystem.guestroom.service.biz;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 房间组服务处理类
 * */
public interface RoomgroupService extends ServiceSupport<Roomgroup, String> {

	/**
	 * 获取所有房间组
	 * 
	 * @return 所有房间组
	 * */
	public Set<Roomgroup> getRoomgroups();

}
