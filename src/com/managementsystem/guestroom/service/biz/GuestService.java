package com.managementsystem.guestroom.service.biz;

import java.util.Map;
import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Guest;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 客人数据服务层操作类
 * */
public interface GuestService extends ServiceSupport<Guest, String> {

	/**
	 * 获取所有客人信息
	 * 
	 * @return 所有客人信息
	 * */
	public Set<Guest> getGuests();

	/**
	 * 获取客人分页信息
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示条数
	 * @param mapParams
	 *            查询MAP
	 * 
	 * @return 客人分页信息
	 * */
	public Page getGuests(int pageIndex, int pageSize,
			Map<String, Object> mapParams);

}
