package com.managementsystem.guestroom.service.platform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.guestroom.dao.platform.EventlogDao;
import com.managementsystem.guestroom.domain.hibernate.Eventlog;
import com.managementsystem.guestroom.service.platform.EventlogService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class EventlogServiceImpl extends
		AbstractServiceSupport<Eventlog, String> implements EventlogService {

	private EventlogDao eventlogDao;

	public EventlogDao getEventlogDao() {
		return eventlogDao;
	}

	@Autowired
	public void setEventlogDao(EventlogDao eventlogDao) {
		this.eventlogDao = eventlogDao;
		setDaoSupport(eventlogDao);
	}

}
