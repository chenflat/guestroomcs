package com.managementsystem.guestroom.service.platform.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.UserDao;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class UserServiceImpl extends AbstractServiceSupport<User, String>
		implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		setDaoSupport(userDao);
	}

	@Transactional(readOnly = true)
	public Set<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional(readOnly = true)
	public Set<User> getUsersByStatus(int status) {
		return userDao.getUsersByStatus(status);
	}

	/**
	 * 复制用户信息，并保存为新用户
	 * 
	 * @param userId
	 *            用户ID
	 * */
	@Transactional
	public User copy(String userId) {
		User currUser = this.get(userId);
		User newUser = null;
		if (currUser != null) {
			try {
				newUser = (User) currUser.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			newUser.setUserId("");
			return this.save(newUser);
		}
		return null;

	}

	@Transactional(readOnly = true)
	public boolean isExistUsername(String username) {
		return userDao.isExistUsername(username);
	}

	@Transactional(readOnly = true)
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}

	@Transactional
	@Override
	public User updatePassword(User user, String newpassword) {
		PasswordEncoder encoder = new Md5PasswordEncoder();
		String password = encoder.encodePassword(newpassword, null);
		user.setPassword(password);
		userDao.update(user);
		return user;
	}
	
	

}
