package com.managementsystem.guestroom.service.platform;

import java.util.Map;
import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Faq;
import com.managementsystem.guestroom.domain.hibernate.Faqcategory;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.ServiceSupport;

/**
 * FAQ服务层操作类
 * 
 * @author CHEN PING
 * @version 2012-11-06 init
 * */
public interface FaqService extends ServiceSupport<Faq,String> {


	/**
	 * 获取指定类别ID的FAQ项
	 * 
	 * @param pageIndex
	 *            当前页索引号
	 * @param pageSize
	 *            每页显示条数
	 * @param catId
	 *            类别ID
	 * */
	public Page getFaqinfosByCatid(int pageIndex, int pageSize, String catId);

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
	public Page getFaqinfosByKeywords(int pageIndex, int pageSize,
			Map<String, Object> mapKeywords);

}
