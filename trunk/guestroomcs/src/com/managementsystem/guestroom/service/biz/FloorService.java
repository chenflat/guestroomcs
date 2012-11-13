package com.managementsystem.guestroom.service.biz;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.ServiceSupport;

/**
 * 建筑楼层服务层操作类
 * 
 * @version 07/11/2012
 * */
public interface FloorService extends ServiceSupport<Floor, String> {
	/**
	 * 获取指定建筑ID的楼层数据
	 * 
	 * @param buildId
	 *            建筑ID
	 * 
	 * @return 建筑楼层
	 * */
	public Set<Floor> getFloorByBuild(String buildId);

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
			Map<String, Object> mapParams);
}
