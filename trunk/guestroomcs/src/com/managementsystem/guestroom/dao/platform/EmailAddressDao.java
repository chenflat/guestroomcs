package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Emailaddress;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 用户电子邮件数据操作接口
 * 
 * @author PING.CHEN
 * */
public interface EmailAddressDao extends DaoSupport {

	/**
	 * 获取指定用户的电子邮件数据
	 * 
	 * @param user
	 *            用户对象
	 * 
	 * @return 用户电子邮件列表
	 * */
	public Set<Emailaddress> getEmailAddressListByUser(User user)
			throws DataAccessException;

}
