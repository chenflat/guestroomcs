package com.managementsystem.guestroom.dao.biz;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 酒店建筑数据操作接口类
 * 
 * @version 07/11/2012 PING.CHEN
 * */
public interface BuildDao extends DaoSupport {
	
	/**
	 * 获取把有建筑信息
	 * @return 建筑信息列表
	 * */
	public Set<Build> getBuilds() throws DataAccessException;
	
	/**
	 * 获取指定酒店的建筑信息
	 * 
	 * @param hotelId 酒店ID
	 * @return 酒店建筑列表
	 * */
	public Set<Build> getBuildsByHotelId(String hotelId) throws DataAccessException;
	
	
}
