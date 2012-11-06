package com.managementsystem.guestroom.dao.platform;

import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.platform.Faqcategory;
import com.managementsystem.util.dao.DaoSupport;
import com.managementsystem.util.dao.Page;


/**
 * FAQ数据操作类
 * */
public interface FaqDao extends DaoSupport {

	/**
	 * 获取FAQ类别列表
	 * 
	 * @return 所有FAQ类别
	 * */
	public Set<Faqcategory> getFaqcategories() throws DataAccessException;

	/**
	 * 获取指定类别的FAQ项
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示数
	 * @param catId
	 *            类别ID
	 * 
	 * @return FAQ分页列表
	 * */
	public Page getFaqItemsByCatid(int pageIndex, int pageSize, String catId)
			throws DataAccessException;

	/**
	 * 获取FAQ查找结果
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示数
	 * @param mapKeywords
	 *            查找关键字
	 * 
	 * @return 查找结果
	 * */
	public Page getFaqItemsByKeywords(int pageIndex, int pageSize,
			Map<String, Object> mapKeywords) throws DataAccessException;

}
