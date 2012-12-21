package com.managementsystem.guestroom.service.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.biz.FloorDao;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class FloorServiceImpl extends AbstractServiceSupport<Floor, String>
		implements FloorService {

	private FloorDao floorDao;

	public FloorDao getFloorDao() {
		return floorDao;
	}

	@Autowired
	public void setFloorDao(FloorDao floorDao) {
		this.floorDao = floorDao;
		setDaoSupport(floorDao);
	}
	

	@Override
	public Floor getFloorByNo(String floorNo) {
		
		return null;
	}

	@Transactional(readOnly = true)
	public Set<Floor> getFloorByBuild(String buildId) {
		return floorDao.getFloorByBuild(buildId);
	}

	@Transactional(readOnly = true)
	public Page getFloors(int pageIndex, int pageSize,
			Map<String, Object> mapParams) {
		if (mapParams == null)
			mapParams = new HashMap<String, Object>();
		return floorDao.getFloors(pageIndex, pageSize, mapParams);
	}

}
