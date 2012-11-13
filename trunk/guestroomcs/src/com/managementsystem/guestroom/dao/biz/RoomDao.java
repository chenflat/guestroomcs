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

	/**
	 * 获取默认酒店的所有客房列表
	 * 
	 * @return 客房列表
	 * */
	public Set<Room> getRoomsByDefHotel() throws DataAccessException;

	/**
	 * 获取指定建筑的所有客房列表
	 * 
	 * @param buildId
	 *            建筑ID
	 * @return 指定建筑的所有客房列表
	 * */
	public Set<Room> getRoomsByBuildId(String buildId)
			throws DataAccessException;

	/**
	 * 获取指定建筑的所有客房列表数量
	 * 
	 * @param buildId
	 *            建筑ID
	 * @return 指定建筑的所有客房数量
	 * */
	public long getCountRoomsByBuildId(String buildId)
			throws DataAccessException;

	/**
	 * 获取默认酒店的所有客房数量
	 * 
	 * @return 默认酒店的所有客房数量
	 * */
	public long getCountRoomsByDefHotel() throws DataAccessException;
}
