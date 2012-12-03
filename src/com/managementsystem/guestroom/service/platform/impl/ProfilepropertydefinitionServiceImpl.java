package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.ProfilepropertydefinitionDao;
import com.managementsystem.guestroom.domain.hibernate.Profilepropertydefinition;
import com.managementsystem.guestroom.service.platform.ProfilepropertydefinitionService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class ProfilepropertydefinitionServiceImpl extends
		AbstractServiceSupport<Profilepropertydefinition, String> implements
		ProfilepropertydefinitionService {

	private ProfilepropertydefinitionDao profilepropertydefinitionDao;

	public ProfilepropertydefinitionDao getProfilepropertydefinitionDao() {
		return profilepropertydefinitionDao;
	}

	@Autowired
	public void setProfilepropertydefinitionDao(
			ProfilepropertydefinitionDao profilepropertydefinitionDao) {
		this.profilepropertydefinitionDao = profilepropertydefinitionDao;
		setDaoSupport(profilepropertydefinitionDao);
	}

	@Transactional(readOnly = true)
	@Override
	public Set<Profilepropertydefinition> getProfileproperties() {
		return profilepropertydefinitionDao.getProfileproperties();
	}

	@Transactional(readOnly = true)
	@Override
	public Set<Profilepropertydefinition> getProfilepropertiesByCategory(
			String propertycategory) {
		return profilepropertydefinitionDao
				.getProfilepropertiesByCategory(propertycategory);
	}

}
