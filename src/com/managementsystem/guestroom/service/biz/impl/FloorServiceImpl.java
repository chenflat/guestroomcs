package com.managementsystem.guestroom.service.biz.impl;

import java.util.List;
import java.util.Map;

import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.AbstractServiceSupport;

public class FloorServiceImpl extends AbstractServiceSupport<Floor, String>
		implements FloorService {

	@Override
	public List<Floor> getFloorByBuild(String buildId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getFloors(int pageIndex, int pageSize,
			Map<String, Object> mapParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
