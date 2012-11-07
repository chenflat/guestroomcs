package com.managementsystem.guestroom.service.biz;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Roomtype;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 客户类型服务类
 * */
public interface RoomtypeService extends ServiceSupport<Roomtype, String> {

	/**
	 * 获取所有客房类型
	 * 
	 * @return 所有客房类型
	 * */
	public Set<Roomtype> getRoomtypes();
}
