package com.managementsystem.guestroom.service.biz;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 酒店信息服务类
 * */
public interface HotelService extends ServiceSupport<Hotel, String> {

	/**
	 * 获取所有酒店
	 * */
	public Set<Hotel> getHotels();

	/**
	 * 获取默认酒店数据
	 * */
	public Hotel getDefaultHotel();
}
