package com.managementsystem.guestroom.service.platform.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.guestroom.dao.platform.PortalDao;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.service.platform.PortalService;

@Service
public class PortalServiceImpl implements PortalService {

	private final Log logger = LogFactory.getLog(PortalServiceImpl.class);
	
	@Autowired
	private PortalDao protalDao;
	
	@Override
	public void savePortalinfo(Portal portal) {
		
	}

	@Override
	public void updatePortalinfo(Portal portal) {

	}

	@Override
	public void deletePortalinfo(String portalId) {

	}

	@Override
	public Portal getPortalinfo(String portalId) {

		return null;
	}

	@Override
	public Portal getDefaultPortalinfo() {

		return null;
	}

}
