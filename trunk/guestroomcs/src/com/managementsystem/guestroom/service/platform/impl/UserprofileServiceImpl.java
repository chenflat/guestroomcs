package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.ProfilepropertydefinitionDao;
import com.managementsystem.guestroom.dao.platform.UserprofileDao;
import com.managementsystem.guestroom.domain.hibernate.Profilepropertydefinition;
import com.managementsystem.guestroom.domain.hibernate.Userprofile;
import com.managementsystem.guestroom.service.platform.ProfilepropertydefinitionService;
import com.managementsystem.guestroom.service.platform.UserprofileService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class UserprofileServiceImpl extends
		AbstractServiceSupport<Userprofile, String> implements
		UserprofileService {

	private UserprofileDao userprofileDao;
	

	public UserprofileDao getUserprofileDao() {
		return userprofileDao;
	}

	@Autowired
	public void setUserprofileDao(UserprofileDao userprofileDao) {
		this.userprofileDao = userprofileDao;
		setDaoSupport(userprofileDao);
	}
	
	

	@Transactional(readOnly = true)
	@Override
	public Set<Userprofile> getUserprofileByUsername(String username) {
		return userprofileDao.getUserprofileByUsername(username);
	}

	@Transactional(readOnly = true)
	@Override
	public Set<Userprofile> getUserprofileByUsername(String username,
			String propertycategory) {
		return userprofileDao.getUserprofileByUsername(username,
				propertycategory);
	}

	@Transactional(readOnly = true)
	@Override
	public Userprofile getUserprofile(String username, String propertyname) {
		return userprofileDao.getUserprofile(username, propertyname);
	}

}
