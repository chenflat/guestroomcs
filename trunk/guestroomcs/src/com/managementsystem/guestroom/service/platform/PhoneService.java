package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Phone;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 用户电话信息服务
 * 
 * @author PING.CHEN
 * */
public interface PhoneService extends ServiceSupport<Phone, String> {

	/**
	 * 获取指定用户的电话列表
	 * 
	 * @param user
	 *            用户对象
	 * 
	 * @return 用户电话列表
	 * */
	public Set<Phone> getPhonesByUser(User user);

}
