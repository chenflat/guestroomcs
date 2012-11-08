package com.managementsystem.guestroom.service.biz.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.biz.RoomtypeDao;
import com.managementsystem.guestroom.domain.hibernate.Roomtype;
import com.managementsystem.guestroom.service.biz.RoomtypeService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class RoomtypeServiceImpl extends
		AbstractServiceSupport<Roomtype, String> implements RoomtypeService {

	private RoomtypeDao roomtypeDao;

	public RoomtypeDao getRoomtypeDao() {
		return roomtypeDao;
	}

	@Autowired
	public void setRoomtypeDao(RoomtypeDao roomtypeDao) {
		this.roomtypeDao = roomtypeDao;
		setDaoSupport(roomtypeDao);
	}

	@Transactional(readOnly = true)
	public Set<Roomtype> getRoomtypes() {
		return roomtypeDao.getRoomtypes();
	}

}
