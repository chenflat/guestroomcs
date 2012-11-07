package com.managementsystem.guestroom.service.platform.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.FaqDao;
import com.managementsystem.guestroom.domain.hibernate.Faq;

import com.managementsystem.guestroom.service.platform.FaqService;
import com.managementsystem.util.dao.Page;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class FaqServiceImpl extends AbstractServiceSupport<Faq, String>
		implements FaqService {

	private final Log logger = LogFactory.getLog(FaqServiceImpl.class);

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
	public Page getFaqinfosByCatid(int pageIndex, int pageSize, String catId) {
		return faqDao.getFaqItemsByCatid(pageIndex, pageSize, catId);
	}

	@Transactional(readOnly = true)
	public Page getFaqinfosByKeywords(int pageIndex, int pageSize,
			Map<String, Object> mapKeywords) {
		return faqDao.getFaqinfosByKeywords(pageIndex, pageSize, mapKeywords);
	}

}
