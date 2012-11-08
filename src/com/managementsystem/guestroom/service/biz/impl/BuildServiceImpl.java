package com.managementsystem.guestroom.service.biz.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.biz.BuildDao;
import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class BuildServiceImpl extends AbstractServiceSupport<Build, String>
		implements BuildService {

	private BuildDao buildDao;

	public BuildDao getBuildDao() {
		return buildDao;
	}

	@Autowired
	public void setBuildDao(BuildDao buildDao) {
		this.buildDao = buildDao;
		setDaoSupport(buildDao);
	}

	@Transactional(readOnly = true)
	public Set<Build> getBuilds() {
		return buildDao.getBuilds();
	}

	@Transactional(readOnly = true)
	public Set<Build> getBuildsByHotelId(String hotelId) {
		return buildDao.getBuildsByHotelId(hotelId);
	}

}
