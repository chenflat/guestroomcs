package com.managementsystem.guestroom.service.platform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.guestroom.dao.platform.ListinfoDao;
import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.guestroom.service.platform.ListinfoService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class ListinfoServiceImpl extends
		AbstractServiceSupport<Listinfo, String> implements ListinfoService {

	private ListinfoDao listinfoDao;

	public ListinfoDao getListinfoDao() {
		return listinfoDao;
	}

	@Autowired
	public void setListinfoDao(ListinfoDao listinfoDao) {
		this.listinfoDao = listinfoDao;
		setDaoSupport(listinfoDao);
	}

}
