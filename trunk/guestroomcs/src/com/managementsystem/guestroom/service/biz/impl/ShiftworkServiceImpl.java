package com.managementsystem.guestroom.service.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.ShiftworkDao;
import com.managementsystem.guestroom.domain.hibernate.Shiftwork;
import com.managementsystem.guestroom.service.biz.ShiftworkService;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class ShiftworkServiceImpl extends
		AbstractServiceSupport<Shiftwork, Long> implements ShiftworkService {

	private ShiftworkDao shiftworkDao;

	public ShiftworkDao getShiftworkDao() {
		return shiftworkDao;
	}

	@Autowired
	public void setShiftworkDao(ShiftworkDao shiftworkDao) {
		this.shiftworkDao = shiftworkDao;
		setDaoSupport(shiftworkDao);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Shiftwork> getShiftworksByUsername(String username) {
		return shiftworkDao.getShiftworksByUsername(username);
	}

	@Transactional(readOnly = true)
	@Override
	public Page getShiftworksByUsername(int pageIndex, int pageSize,
			String username) {
		return shiftworkDao.getShiftworksByUsername(pageIndex, pageSize,
				username);
	}

	@Transactional(readOnly = true)
	@Override
	public Shiftwork getLastShiftworkByUsername(String username) {
		return shiftworkDao.getLastShiftworkByUsername(username);
	}

}
