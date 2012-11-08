package com.managementsystem.guestroom.service.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.guestroom.dao.biz.GuestpreferenceDao;
import com.managementsystem.guestroom.domain.hibernate.Guestpreference;
import com.managementsystem.guestroom.domain.hibernate.GuestpreferenceId;
import com.managementsystem.guestroom.service.biz.GuestpreferenceService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class GuestpreferenceServiceImpl extends
		AbstractServiceSupport<Guestpreference, GuestpreferenceId> implements
		GuestpreferenceService {

	private GuestpreferenceDao guestpreferenceDao;

	public GuestpreferenceDao getGuestpreferenceDao() {
		return guestpreferenceDao;
	}

	@Autowired
	public void setGuestpreferenceDao(GuestpreferenceDao guestpreferenceDao) {
		this.guestpreferenceDao = guestpreferenceDao;
		setDaoSupport(guestpreferenceDao);
	}

}
