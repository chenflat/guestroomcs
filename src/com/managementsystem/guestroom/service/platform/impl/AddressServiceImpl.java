package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.AddressDao;
import com.managementsystem.guestroom.domain.hibernate.Address;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.service.platform.AddressService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class AddressServiceImpl extends AbstractServiceSupport<Address, String>
		implements AddressService {

	private AddressDao addressDao;

	public AddressDao getAddressDao() {
		return addressDao;
	}

	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
		setDaoSupport(addressDao);
	}

	@Transactional(readOnly = true)
	public Set<Address> getAddressListByUser(User user) {
		return addressDao.getAddressListByUser(user);
	}

}
