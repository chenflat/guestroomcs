package com.managementsystem.guestroom.dao.biz;

import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Guest;
import com.managementsystem.util.dao.DaoSupport;
import com.managementsystem.util.dao.Page;

/**
 * 客人数据操作类
 * 
 * @version 07/11/2012 PING.CHEN
 * */
public interface GuestDao extends DaoSupport {

	/**
	 * 获取所有客人信息
	 * 
	 * @return 所有客人信息
	 * */
	public Set<Guest> getGuests() throws DataAccessException;

	/**
	 * 获取客人分页信息
	 * 
	 * @param pageIndex 当前页索引
	 * @param pageSize 每页显示条数
	 * @param mapParams	查询MAP
	 * 
	 * @return 客人分页信息
	 * */
	public Page getGuests(int pageIndex, int pageSize,
			Map<String, Object> mapParams) throws DataAccessException;

}
