package com.managementsystem.guestroom.dao.biz;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Roomtype;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 客房类别数据操作类
 * 
 * @version 07/11/2012 PING.CHEN
 * */
public interface RoomtypeDao extends DaoSupport {

	/**
	 * 获取所有客房类型
	 * 
	 * @return 所有客房类型
	 * */
	public Set<Roomtype> getRoomtypes() throws DataAccessException;

}
