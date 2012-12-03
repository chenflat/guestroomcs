package com.managementsystem.guestroom.service.biz;

import java.util.List;

import com.managementsystem.guestroom.domain.hibernate.Shiftwork;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 交接班记录服务操作类
 * 
 * @author ping.chen
 * */
public interface ShiftworkService extends ServiceSupport<Shiftwork, Long> {

	/**
	 * 获取指定用户的交接班记录
	 * 
	 * @param username
	 *            用户名
	 * @return 用户交接班记录
	 * */
	public List<Shiftwork> getShiftworksByUsername(String username);

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
			String username);

	/**
	 * 获取指定用户的最后交接班记录
	 * 
	 * @param username
	 *            用户名
	 * @return 用户交接班记录
	 * */
	public Shiftwork getLastShiftworkByUsername(String username);
}
