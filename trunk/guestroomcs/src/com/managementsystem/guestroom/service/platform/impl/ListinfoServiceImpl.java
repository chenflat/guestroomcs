package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

	@Transactional(readOnly = true)
	public Set<Listinfo> getListinfoDictionary() {
		return listinfoDao.getListinfoDictionary();
	}

	@Transactional(readOnly = true)
	public Set<Listinfo> getListEntryItems(String listName) {
		if (!StringUtils.hasLength(listName)) {
			throw new NullPointerException("listName is null or empty");
		}
		return listinfoDao.getListEntryItems(listName);
	}

	@Transactional(readOnly = true)
	public Set<Listinfo> getListEntryItems(String listName, String parentKey) {
		return listinfoDao.getListEntryItems(listName, parentKey);
	}

}
