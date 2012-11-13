package com.managementsystem.guestroom.service.biz.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.biz.HotelDao;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class HotelServiceImpl extends AbstractServiceSupport<Hotel, String>
		implements HotelService {

	private HotelDao hotelDao;

	public HotelDao getHotelDao() {
		return hotelDao;
	}

	@Autowired
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
		setDaoSupport(hotelDao);
	}

	@Transactional(readOnly = true)
	public Set<Hotel> getHotels() {
		return hotelDao.getHotels();
	}

	@Transactional(readOnly = true)
	public Hotel getDefaultHotel() {
		return hotelDao.getDefaultHotel();
	}

}
