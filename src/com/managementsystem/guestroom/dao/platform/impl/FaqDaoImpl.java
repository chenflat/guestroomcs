package com.managementsystem.guestroom.dao.platform.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.platform.FaqDao;
import com.managementsystem.guestroom.domain.hibernate.Faq;
import com.managementsystem.guestroom.domain.hibernate.Faqcategory;
import com.managementsystem.util.dao.AbstractDaoSupport;
import com.managementsystem.util.dao.Page;

@Repository
public class FaqDaoImpl extends AbstractDaoSupport implements FaqDao {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Faq.class, Faqcategory.class }));

	private final static String GETFAQCATEGORIES = "from Faqcategory order by catOrder";
	private final static String GETFAQITEMSBYCATID = "from Faq where faqcategory.catId=? order by priority desc";
	private final static String GETFAQITEMSBYKEYWORDS = "from Faq order by priority desc";
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Faqcategory> getFaqcategories() throws DataAccessException {
		Query query = createQuery(GETFAQCATEGORIES);
		return new LinkedHashSet<Faqcategory>(query.list());
	}

	@Override
	public Page getFaqItemsByCatid(int pageIndex, int pageSize, String catId)
			throws DataAccessException {
		return pagedQuery(GETFAQITEMSBYCATID, pageIndex, pageSize, catId);
	}

	@Override
	public Page getFaqinfosByKeywords(int pageIndex, int pageSize,
			Map<String, Object> mapKeywords) throws DataAccessException {
		return pagedQuery(GETFAQITEMSBYKEYWORDS, pageIndex, pageSize,
				mapKeywords);
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@Override
	public boolean canBeMerged(Object o) {
		return true;
	}

}
