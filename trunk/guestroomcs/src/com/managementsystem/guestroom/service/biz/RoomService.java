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

	/**
	 * 获取默认酒店的所有客房列表
	 * 
	 * @return 客房列表
	 * */
	public Set<Room> getRoomsByDefHotel();

	/**
	 * 获取指定建筑的所有客房列表
	 * 
	 * @param buildId
	 *            建筑ID
	 * @return 指定建筑的所有客房列表
	 * */
	public Set<Room> getRoomsByBuildId(String buildId);

	/**
	 * 获取指定建筑的所有客房列表数量
	 * 
	 * @param buildId
	 *            建筑ID
	 * @return 指定建筑的所有客房列表
	 * */
	public long getCountRoomsByBuildId(String buildId);

	/**
	 * 获取默认酒店的所有客房数量
	 * 
	 * @return 默认酒店的所有客房数量
	 * */
	public long getCountRoomsByDefHotel();
}
