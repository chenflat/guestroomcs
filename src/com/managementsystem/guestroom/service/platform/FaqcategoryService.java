package com.managementsystem.guestroom.service.platform;

import java.util.List;

import com.managementsystem.guestroom.domain.hibernate.Faqcategory;
import com.managementsystem.util.service.ServiceSupport;

/**
 * FAQ类别服务层操作类
 * */
public interface FaqcategoryService extends ServiceSupport<Faqcategory, String> {

	/**
	 * 获取所有FAQ类别
	 * */
	public List<Faqcategory> getFaqcategories();
}
