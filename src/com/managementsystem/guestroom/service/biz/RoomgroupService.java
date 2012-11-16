package com.managementsystem.guestroom.service.biz;

import java.util.List;
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
	
	/**
	 * 编辑保存时删除未在列表中的房间组
	 * @param roomgroups;
	 * */
	public void deleteExcludeIds(List<Roomgroup> roomgroups);
	
	
}
