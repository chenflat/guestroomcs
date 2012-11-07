package com.managementsystem.guestroom.dao.biz;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 房间数据操作类
 * 
 * @version 07/11/2012 PING.CHEN
 * */
public interface RoomDao extends DaoSupport {

	/**
	 * 获取指定楼层ID的所有房间
	 * 
	 * @param floorId
	 *            建筑楼层ID
	 * @return 楼层所有房间
	 * */
	public Set<Room> getRoomsByFloorId(String floorId)
			throws DataAccessException;

}
