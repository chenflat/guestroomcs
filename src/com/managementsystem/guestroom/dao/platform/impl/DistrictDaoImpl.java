package com.managementsystem.guestroom.dao.platform.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.platform.DistrictDao;
import com.managementsystem.guestroom.domain.hibernate.District;
import com.managementsystem.util.dao.AbstractDaoSupport;
import com.managementsystem.util.dao.Page;

@Repository
public class DistrictDaoImpl extends AbstractDaoSupport implements DistrictDao {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { District.class }));

	private final String GET_DISTRICTS = "from District order by districtId asc";
	private final String GET_ROOT_DISTRICTS = "from District where (district is null or district.districtId='')  order by districtId asc";
	private final String GET_DISTRICTS_BY_PARENTID = "from District where district.districtId=?  order by districtId asc";

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<District> getAllDistricts(int startResult, int maxRows)
			throws DataAccessException {
		
	//	Query query1 = getSession().createQuery(GET_DISTRICTS);
		
		Query query = createQuery(GET_DISTRICTS, startResult, maxRows);
		return new LinkedHashSet<District>(query.list());
	}

	@Override
	public Page getDistricts(int pageIndex, int pageSize,
			Map<String, Object> mapParams) throws DataAccessException {
		return pagedQuery(GET_DISTRICTS, pageIndex, pageSize, mapParams);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page getDistrictsByCriterion(int pageIndex, int pageSize,
			Map<String, Object> mapParams) throws DataAccessException {
		Criteria criteria = getSession().createCriteria(District.class);
		int i = 0;
		for (Iterator<String> iterator = mapParams.keySet().iterator(); iterator
				.hasNext();) {
			String key = iterator.next();
			Object value = mapParams.get(key);
			Criterion c = Restrictions.like(key, value);
			criteria.add(c);
			i++;
		}
		long totalCount = (Long) criteria.setProjection(Projections.rowCount())
				.uniqueResult();
		criteria.setProjection(null);

		if (totalCount < 1)
			return new Page();
		if (pageIndex < 1)
			pageIndex = 1;

		int firstResult = Page.getStartOfPage(pageIndex, pageSize);
		criteria.setFirstResult(firstResult < 0 ? DEFAULT_FIRST_RESULT_INDEX
				: firstResult);
		if (pageSize > 0)
			criteria.setMaxResults(pageSize);
		List list = criteria.list();
		return new Page(firstResult, totalCount, pageSize, list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<District> getRootDistricts(int startResult, int maxRows)
			throws DataAccessException {
		Query query = createQuery(GET_ROOT_DISTRICTS, startResult, maxRows);
		return new LinkedHashSet<District>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<District> getDistrictsByParentId(String districtId,
			int startResult, int maxRows) throws DataAccessException {
		Query query = createQuery(GET_DISTRICTS_BY_PARENTID, startResult,
				maxRows, districtId);
		return new LinkedHashSet<District>(query.list());
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
