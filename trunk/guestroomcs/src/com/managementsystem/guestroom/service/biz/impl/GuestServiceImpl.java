package com.managementsystem.guestroom.service.biz.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.biz.GuestDao;
import com.managementsystem.guestroom.domain.hibernate.Guest;
import com.managementsystem.guestroom.service.biz.GuestService;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class GuestServiceImpl extends AbstractServiceSupport<Guest, String>
		implements GuestService {

	private GuestDao guestDao;

	public GuestDao getGuestDao() {
		return guestDao;
	}

	@Autowired
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
		setDaoSupport(guestDao);
	}

	@Transactional(readOnly = true)
	public Set<Guest> getGuests() {
		return guestDao.getGuests();
	}

	@Transactional(readOnly = true)
	public Page getGuests(int pageIndex, int pageSize,
			Map<String, Object> mapParams) {
		if (mapParams == null)
			mapParams = new HashMap<String, Object>();
		return guestDao.getGuests(pageIndex, pageSize, mapParams);
	}

}
