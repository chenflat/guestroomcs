package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Address;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 用户地址服务类
 * 
 * @author PING.CHEN
 * */
public interface AddressService extends ServiceSupport<Address, String> {

	/**
	 * 获取指定用户的地址列表
	 * 
	 * @param user
	 *            用户信息
	 * @return 用户地址列表
	 * */
	public Set<Address> getAddressListByUser(User user);

}
