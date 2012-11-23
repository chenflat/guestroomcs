package com.managementsystem.guestroom.service.platform.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.dao.platform.ResourceDao;
import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.platform.ResourceType;
import com.managementsystem.guestroom.service.platform.ResourceService;
import com.managementsystem.ui.easyui.Tree;
import com.managementsystem.ui.easyui.TreeUtil;
import com.managementsystem.util.service.AbstractServiceSupport;

@Service
public class ResourceServiceImpl extends
		AbstractServiceSupport<Resource, String> implements ResourceService {

	private ResourceDao resourceDao;

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
		setDaoSupport(resourceDao);
	}

	@Transactional(readOnly = true)
	public List<Resource> getResourceByType(ResourceType type) {
		return resourceDao.getResourceByType(type);
	}

	@Transactional(readOnly = true)
	public List<Resource> getUrlTypeOfResources() {
		return resourceDao.getResourceUrls();
	}

	@Transactional(readOnly = true)
	public List<Resource> getResources() {
		return resourceDao.getResources();
	}

	@Transactional(readOnly = true)
	public List<Resource> getChildrenResource(String resourceId) {
		return resourceDao.getChildrenResource(resourceId);
	}

	@Transactional(readOnly = true)
	public List<Resource> getMethodsOfResource(String resourceId) {
		return resourceDao.getMethodsOfResource(resourceId);
	}

	@Transactional(readOnly = true)
	public List<Tree> getUrlTypeOfResourcesTree() {
		List<Tree> treelist = new ArrayList<Tree>();
		List<Resource> resources = resourceDao.getResourceUrls();
		for (Resource res : resources) {
			Tree tree = transform(res);
			treelist.add(tree);
		}
		return TreeUtil.build(treelist);
	}

	/**
	 * 树型类赋值
	 * 
	 * @param resource
	 *            资源类
	 * */
	private Tree transform(Resource resource) {
		Tree tree = new Tree();
		tree.setId(resource.getResourceId());
		tree.setText(resource.getResourceName());
		tree.setParentid(resource.get_parentId());
		return tree;
	}
}
