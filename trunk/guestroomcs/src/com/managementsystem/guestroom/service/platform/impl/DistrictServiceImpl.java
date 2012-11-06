package com.managementsystem.guestroom.service.platform.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.managementsystem.guestroom.dao.platform.DistrictDao;
import com.managementsystem.guestroom.domain.hibernate.District;
import com.managementsystem.guestroom.service.platform.DistrictService;
import com.managementsystem.util.dao.Page;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictDao districtDao;

	@Transactional
	public void addDistrict(District District) {
		if (!StringUtils.hasLength(District.getDistrict().getDistrictId())) {
			District.setDistrict(null);
		}
		districtDao.save(District);
	}

	@Transactional
	public void updateDistrict(District District) {
		if (!StringUtils.hasLength(District.getDistrict().getDistrictId())) {
			District.setDistrict(null);
		}
		districtDao.update(District);
	}

	@Transactional
	public void deleteDistrict(String districtId) {
		District District = getDistrict(districtId);
		if (District != null)
			districtDao.delete(District);
	}

	@Transactional(readOnly = true)
	public District getDistrict(String districtId) {
		return (District) districtDao.get(District.class, districtId);
	}

	@Transactional(readOnly = true)
	public Set<District> getAllDistricts(int startResult, int maxRows) {
		return districtDao.getAllDistricts(startResult, maxRows);
	}

	@Transactional(readOnly = true)
	public Set<District> getRootDistricts(int startResult, int maxRows) {
		return districtDao.getRootDistricts(startResult, maxRows);
	}

	@Transactional(readOnly = true)
	public Set<District> getDistrictsByParentId(String districtId,
			int startResult, int maxRows) {
		return districtDao.getDistrictsByParentId(districtId, startResult,
				maxRows);
	}

	@Transactional(readOnly = true)
	public Page getPagedDictgrouies(int pageIndex, int pageSize,
			Map<String, Object> mapCondition) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Iterator<String> iterator = mapCondition.keySet().iterator(); iterator
				.hasNext();) {
			String key = iterator.next();
			Object value = mapCondition.get(key);
			if (StringUtils.hasLength(value.toString())) {
				map.put(key, value);
			}
		}
		return districtDao.getDistricts(pageIndex, pageSize, map);
	}

}
