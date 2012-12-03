package com.managementsystem.guestroom.dao.platform;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Shiftwork;
import com.managementsystem.util.dao.DaoSupport;
import com.managementsystem.util.dao.Page;

/**
 * 交接班记录数据操作类
 * 
 * @author ping.chen
 * */
public interface ShiftworkDao extends DaoSupport {

	/**
	 * 获取指定用户的交接班记录
	 * 
	 * @param username
	 *            用户名
	 * @return 用户交接班记录
	 * */
	public List<Shiftwork> getShiftworksByUsername(String username)
			throws DataAccessException;

	/**
	 * 获取指定用户的交接班记录
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示数
	 * @param username
	 *            用户名
	 * @return 用户交接班分分页记录
	 * */
	public Page getShiftworksByUsername(int pageIndex, int pageSize,
			String username) throws DataAccessException;

	/**
	 * 获取指定用户的最后交接班记录
	 * 
	 * @param username
	 *            用户名
	 * @return 用户交接班记录
	 * */
	public Shiftwork getLastShiftworkByUsername(String username)
			throws DataAccessException;

}
