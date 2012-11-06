package com.managementsystem.guestroom.service.platform.impl;

import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.managementsystem.guestroom.dao.platform.FaqDao;
import com.managementsystem.guestroom.domain.hibernate.Faq;
import com.managementsystem.guestroom.domain.hibernate.Faqcategory;
import com.managementsystem.guestroom.service.platform.FaqService;
import com.managementsystem.util.dao.Page;

@Service
public class FaqServiceImpl implements FaqService {

	private final Log logger = LogFactory.getLog(FaqServiceImpl.class);

	@Autowired
	private FaqDao faqDao;

	@Transactional
	public String saveFaqcategory(Faqcategory faqcategory) {
		return (String) faqDao.save(faqcategory);
	}

	@Transactional
	public void updateFaqcategory(Faqcategory faqcategory) {
		if (StringUtils.hasLength(faqcategory.getCatId())) {
			faqDao.update(faqcategory);
		} else {
			throw new NullPointerException(
					"faq category object's id is null or empty");
		}
	}

	@Transactional
	public void deleteFaqcategory(String catId) {
		Faqcategory faqcategory = getFaqcategory(catId);
		if (faqcategory != null) {
			faqDao.delete(faqcategory);
		}
	}

	@Transactional(readOnly = true)
	public Faqcategory getFaqcategory(String catId) {
		if (StringUtils.hasLength(catId)) {
			return (Faqcategory) faqDao.get(Faqcategory.class, catId);
		} else {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public Set<Faqcategory> getFaqcategories() {
		return faqDao.getFaqcategories();
	}

	@Transactional
	public String saveFaqinfo(Faq faqinfo) {
		return (String) faqDao.save(faqinfo);
	}

	@Transactional
	public void updateFaqinfo(Faq faqinfo) {
		if (StringUtils.hasLength(faqinfo.getFaqId())) {
			faqDao.update(faqinfo);
		} else {
			throw new NullPointerException("faq object's id is null or empty");
		}

	}

	@Transactional
	public void deleteFaqinfo(String faqId) {
		if (StringUtils.hasLength(faqId)) {
			Faq faqinfo = getFaqinfo(faqId);
			if (faqinfo != null) {
				faqDao.delete(faqinfo);
			}
		} else {
			logger.error("method=deleteFaqinfo faq object's id is null or empty");
			throw new NullPointerException("faq object's id is null or empty");
		}
	}

	@Transactional(readOnly = true)
	public Faq getFaqinfo(String faqId) {
		if (StringUtils.hasLength(faqId)) {
			return (Faq) faqDao.get(Faq.class, faqId);
		}
		return null;
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
