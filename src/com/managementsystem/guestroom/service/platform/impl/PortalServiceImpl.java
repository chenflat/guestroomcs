package com.managementsystem.guestroom.service.platform.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.PortalDao;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.service.platform.PortalService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class PortalServiceImpl extends AbstractServiceSupport<Portal, String>
		implements PortalService {

	private final Log logger = LogFactory.getLog(PortalServiceImpl.class);

	private PortalDao portalDao;

	public PortalDao getPortalDao() {
		return portalDao;
	}

	@Autowired
	public void setPortalDao(PortalDao portalDao) {
		this.portalDao = portalDao;
		setDaoSupport(portalDao);
	}

	@Transactional(readOnly = true)
	public Portal getDefaultPortalinfo() {
		return portalDao.getDefaultPortalInfo();
	}

}
