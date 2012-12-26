package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Address;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.util.dao.DaoSupport;


/**
 * 用户地址数据操作接口
 * 
 * @author PING.CHEN
 * */
public interface AddressDao extends DaoSupport {

	/**
	 * 获取指定用户的地址列表
	 * 
	 * @param user 用户对象
	 * 
	 * @return 用户地址列表
	 * */
	public Set<Address> getAddressListByUser(User user) throws DataAccessException;
	
}
