package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.PhoneDao;
import com.managementsystem.guestroom.domain.hibernate.Phone;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.service.platform.PhoneService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class PhoneServiceImpl extends AbstractServiceSupport<Phone, String>
		implements PhoneService {

	private PhoneDao phoneDao;
	
	
	public PhoneDao getPhoneDao() {
		return phoneDao;
	}

	@Autowired
	public void setPhoneDao(PhoneDao phoneDao) {
		this.phoneDao = phoneDao;
		setDaoSupport(phoneDao);
	}

	@Transactional(readOnly = true)
	@Override
	public Set<Phone> getPhonesByUser(User user) {
		return phoneDao.getPhonesByUser(user);
	}

	
}
