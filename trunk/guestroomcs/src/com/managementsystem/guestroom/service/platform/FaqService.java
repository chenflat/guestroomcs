package com.managementsystem.guestroom.service.platform;

import java.util.Map;
import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Faq;
import com.managementsystem.guestroom.domain.hibernate.Faqcategory;
import com.managementsystem.util.dao.Page;

/**
 * FAQ服务层操作类
 * 
 * @author CHEN PING
 * @version 2012-11-06 init
 * */
public interface FaqService {

	/**
	 * 新增FAQ类别信息
	 * 
	 * @param faqcategory
	 *            FAQ类别
	 * */
	public String saveFaqcategory(Faqcategory faqcategory);

	/**
	 * 更新FAQ类别信息
	 * 
	 * @param faqcategory
	 *            FAQ类别
	 * */
	public void updateFaqcategory(Faqcategory faqcategory);

	/**
	 * 删除FAQ类别信息
	 * 
	 * @param catId
	 *            类别ID
	 * */
	public void deleteFaqcategory(String catId);

	/**
	 * 获取FAQ类别对象
	 * 
	 * @param catId
	 *            类别ID
	 * @return FAQ类别对象
	 * */
	public Faqcategory getFaqcategory(String catId);

	/**
	 * 获取所有FAQ类别
	 * */
	public Set<Faqcategory> getFaqcategories();

	/**
	 * 保存Faq信息
	 * 
	 * @param faqinfo
	 *            FAQ信息
	 * */
	public String saveFaqinfo(Faq faqinfo);

	/**
	 * 更新Faq信息
	 * 
	 * @param faqinfo
	 *            FAQ信息
	 * */
	public void updateFaqinfo(Faq faqinfo);

	/**
	 * 删除Faq信息
	 * 
	 * @param faqId
	 *            FAQ对象ID
	 * */
	public void deleteFaqinfo(String faqId);

	/**
	 * 获取Faq信息
	 * 
	 * @param faqId
	 *            FAQ对象ID
	 * 
	 * @return Faq信息
	 * */
	public Faq getFaqinfo(String faqId);

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
