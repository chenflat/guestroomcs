package com.managementsystem.guestroom.domain.hibernate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * 权限资源信息类
 * */
public class Resource implements java.io.Serializable {

	private static final long serialVersionUID = -7451503960951416484L;
	private String resourceId;
	private Resource resource;
	private String resourceName;
	private String resourceType;
	private Integer priority;
	private String resourceString;
	private String resourceDesc;
	private Integer status;
	@JsonBackReference
	private Set resources = new HashSet(0);
	@JsonBackReference
	private Set roles = new HashSet(0);
	@JsonBackReference
	private List<Resource> resourcelist = new LinkedList<Resource>();

	private String _parentId;

	public Resource() {
	}

	public Resource(String resourceId) {
		this.resourceId = resourceId;
	}

	public Resource(String resourceId, Resource resource, String resourceName,
			String resourceType, Integer priority, String resourceString,
			String resourceDesc, Integer status, Set resources, Set roles) {
		this.resourceId = resourceId;
		this.resource = resource;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.priority = priority;
		this.resourceString = resourceString;
		this.resourceDesc = resourceDesc;
		this.status = status;
		this.resources = resources;
		this.roles = roles;
	}

	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getResourceString() {
		return this.resourceString;
	}

	public void setResourceString(String resourceString) {
		this.resourceString = resourceString;
	}

	public String getResourceDesc() {
		return this.resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getResources() {
		return this.resources;
	}

	public void setResources(Set resources) {
		this.resources = resources;
	}

	public Set getRoles() {
		return this.roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	public String get_parentId() {
		if (resource == null)
			_parentId = "";
		else
			_parentId = resource.getResourceId();
		return _parentId;
	}

	public List<Resource> getResourcelist() {
		/*if(resourcelist==null)
			return new LinkedList<Resource>(resources);*/
		return resourcelist;
	}

	public void setResourcelist(List<Resource> resourcelist) {
		
		//this.resources = new HashSet<Resource>(resourcelist);
		
		this.resourcelist = resourcelist;
	}


	
}
