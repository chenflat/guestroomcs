package com.managementsystem.guestroom.service.biz.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.biz.RoomgroupDao;
import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.guestroom.service.biz.RoomgroupService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class RoomgroupServiceImpl extends
		AbstractServiceSupport<Roomgroup, String> implements RoomgroupService {

	private RoomgroupDao roomgroupDao;

	public RoomgroupDao getRoomgroupDao() {
		return roomgroupDao;
	}

	@Autowired
	public void setRoomgroupDao(RoomgroupDao roomgroupDao) {
		this.roomgroupDao = roomgroupDao;
		setDaoSupport(roomgroupDao);
	}

	@Transactional(readOnly = true)
	public Set<Roomgroup> getRoomgroups() {
		return roomgroupDao.getRoomgroups();
	}

}
