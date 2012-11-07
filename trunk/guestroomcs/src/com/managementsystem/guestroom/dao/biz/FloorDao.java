package com.managementsystem.guestroom.dao.biz;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.util.dao.DaoSupport;
import com.managementsystem.util.dao.Page;

/**
 * 酒店楼层数据操作类
 * 
 * @author 07/11/2012 PING.CHEN
 * */
public interface FloorDao extends DaoSupport {

	/**
	 * 获取指定建筑ID的楼层数据
	 * 
	 * @param buildId
	 *            建筑ID
	 * 
	 * @return 建筑楼层
	 * */
	public List<Floor> getFloorByBuild(String buildId)
			throws DataAccessException;

	/**
	 * 获取楼层分页数据
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示条数
	 * @param mapParams
	 *            查询参数
	 * */
	public Page getFloors(int pageIndex, int pageSize,
			Map<String, Object> mapParams) throws DataAccessException;

}
