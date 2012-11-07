package com.managementsystem.guestroom.service.biz;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 建筑数据服务层操作类
 * 
 * @version 07/11/2012 PING.CHEN
 * */
public interface BuildService extends ServiceSupport<Build, String> {

	/**
	 * 获取把有建筑信息
	 * 
	 * @return 建筑信息列表
	 * */
	public Set<Build> getBuilds();

	/**
	 * 获取指定酒店的建筑信息
	 * 
	 * @param hotelId
	 *            酒店ID
	 * @return 酒店建筑列表
	 * */
	public Set<Build> getBuildsByHotelId(String hotelId);
}
