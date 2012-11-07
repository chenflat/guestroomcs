package com.managementsystem.guestroom.service.biz.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class BuildServiceImpl extends AbstractServiceSupport<Build, String>
		implements BuildService {

	@Override
	public Set<Build> getBuilds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Build> getBuildsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
