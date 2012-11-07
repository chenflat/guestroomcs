/**
 * 
 */
package com.managementsystem.guestroom.service.platform.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.FaqDao;
import com.managementsystem.guestroom.domain.hibernate.Faqcategory;
import com.managementsystem.guestroom.service.platform.FaqcategoryService;
import com.managementsystem.util.service.AbstractServiceSupport;

/**
 * FAQ类别服务层操作类
 * 
 * @author CHENPING
 */
@Service
public class FaqcategoryServiceImpl extends
		AbstractServiceSupport<Faqcategory, String> implements
		FaqcategoryService {

	private FaqDao faqDao;

	public FaqDao getFaqDao() {
		return faqDao;
	}

	@Autowired
	public void setFaqDao(FaqDao faqDao) {
		this.faqDao = faqDao;
		setDaoSupport(faqDao);
	}

	@Transactional(readOnly = true)
	public List<Faqcategory> getFaqcategories() {
		return new ArrayList<Faqcategory>(faqDao.getFaqcategories());
	}

}
