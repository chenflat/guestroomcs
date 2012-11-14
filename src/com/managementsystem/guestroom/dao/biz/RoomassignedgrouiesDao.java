package com.managementsystem.guestroom.dao.biz;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Roomassignedgrouies;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 房间与房间组关系
 * */
public interface RoomassignedgrouiesDao extends DaoSupport {

	/**
	 * 获取客房对应的关系条目
	 * 
	 * @param roomNo
	 *            房间编号
	 * 
	 * @return 客房对应的关系条目
	 * */
	public Set<Roomassignedgrouies> getRoomassignedgrouiesListByRoomNo(
			String roomNo);

}
