package com.managementsystem.guestroom.dao.biz;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 酒店信息数据操作接口
 * 
 * @version 2012.11.07 PING.CHEN
 * */
public interface HotelDao extends DaoSupport {
	
	/**
	 * 获取所有酒店
	 * */
	public Set<Hotel> getHotels() throws DataAccessException;
	
	
}
