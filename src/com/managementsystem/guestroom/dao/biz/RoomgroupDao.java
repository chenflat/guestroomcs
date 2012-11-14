package com.managementsystem.guestroom.dao.biz;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 房间组数据操作类
 * */
public interface RoomgroupDao extends DaoSupport {
	
	/**
	 * 获取所有房间分组
	 * */
	public Set<Roomgroup> getRoomgroups() throws DataAccessException;
	
	
}
