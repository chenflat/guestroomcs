package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Emailaddress;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 用户电子邮件服务接口
 * 
 * @author PING.CHEN
 * */
public interface EmailaddressService extends
		ServiceSupport<Emailaddress, String> {

	
	/**
	 * 获取指定用户的电子邮件数据
	 * 
	 * @param user
	 *            用户对象
	 * 
	 * @return 用户电子邮件列表
	 * */
	public Set<Emailaddress> getEmailAddressListByUser(User user);
	
}
