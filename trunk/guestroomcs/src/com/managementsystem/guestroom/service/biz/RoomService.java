package com.managementsystem.guestroom.service.biz;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 客房服务类
 * */
public interface RoomService extends ServiceSupport<Room, String> {
	
	/**
	 * 获取指定楼层ID的所有房间
	 * 
	 * @param floorId
	 *            建筑楼层ID
	 * @return 楼层所有房间
	 * */
	public Set<Room> getRoomsByFloorId(String floorId);
	
}
