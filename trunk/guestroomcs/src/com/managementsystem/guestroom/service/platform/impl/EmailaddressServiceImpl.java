package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.EmailAddressDao;
import com.managementsystem.guestroom.domain.hibernate.Emailaddress;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.service.platform.EmailaddressService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class EmailaddressServiceImpl extends
		AbstractServiceSupport<Emailaddress, String> implements
		EmailaddressService {

	private EmailAddressDao emailAddressDao;

	public EmailAddressDao getEmailAddressDao() {
		return emailAddressDao;
	}

	@Autowired
	public void setEmailAddressDao(EmailAddressDao emailAddressDao) {
		this.emailAddressDao = emailAddressDao;
		setDaoSupport(emailAddressDao);
	}

	@Transactional(readOnly = true)
	public Set<Emailaddress> getEmailAddressListByUser(User user) {
		return emailAddressDao.getEmailAddressListByUser(user);
	}

}
