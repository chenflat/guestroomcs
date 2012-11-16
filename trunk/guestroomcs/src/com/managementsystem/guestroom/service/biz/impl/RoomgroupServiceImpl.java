package com.managementsystem.guestroom.service.biz.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.managementsystem.guestroom.dao.biz.RoomgroupDao;
import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.guestroom.service.biz.RoomgroupService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class RoomgroupServiceImpl extends
		AbstractServiceSupport<Roomgroup, String> implements RoomgroupService {

	private final Log logger = LogFactory.getLog(RoomgroupServiceImpl.class);

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

	@Transactional
	public void deleteExcludeIds(List<Roomgroup> inputRoomgroups) {
		Set<Roomgroup> existRoomgroups = getRoomgroups();
		for (Roomgroup roomgroup : existRoomgroups) {
			boolean exist = false;
			for (Roomgroup input : inputRoomgroups) {
				if (roomgroup.getRoomgroupId().equals(input.getRoomgroupId())) {
					exist = true;
				}
			}
			if (!exist) {
				logger.info("exccludeIds:" + roomgroup.getRoomgroupId());
				this.delete(roomgroup.getRoomgroupId());
			}

		}

	}
}
