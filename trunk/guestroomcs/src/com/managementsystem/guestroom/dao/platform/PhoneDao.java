package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Phone;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 用户电话数据操作接口
 * 
 * @author PING.CHEN
 * */
public interface PhoneDao extends DaoSupport {

	/**
	 * 获取指定用户的电话数据
	 * 
	 * @param user
	 *            用户对象
	 * 
	 * @return 电话数据列表
	 * */
	public Set<Phone> getPhonesByUser(User user) throws DataAccessException;

}
