package com.managementsystem.guestroom.service.biz.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.managementsystem.guestroom.dao.biz.RoomDao;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class RoomServiceImpl extends AbstractServiceSupport<Room, String>
		implements RoomService {

	private RoomDao roomDao;

	public RoomDao getRoomDao() {
		return roomDao;
	}

	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
		setDaoSupport(roomDao);
	}

	@Transactional(readOnly = true)
	public Set<Room> getRoomsByFloorId(String floorId) {
		if (!StringUtils.hasLength(floorId))
			throw new NullPointerException("floorId is null or empty!");
		return roomDao.getRoomsByFloorId(floorId);
	}

}
