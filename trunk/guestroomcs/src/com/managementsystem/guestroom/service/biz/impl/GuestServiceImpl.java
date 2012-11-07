package com.managementsystem.guestroom.service.biz.impl;

import java.util.Map;
import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Guest;
import com.managementsystem.guestroom.service.biz.GuestService;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.AbstractServiceSupport;

public class GuestServiceImpl extends AbstractServiceSupport<Guest, String>
		implements GuestService {

	@Override
	public Set<Guest> getGuests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getGuests(int pageIndex, int pageSize,
			Map<String, Object> mapParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
