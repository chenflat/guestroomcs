package com.managementsystem.guestroom.domain.hibernate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 3331315193198369869L;
	private String roleId;
	private String roleName;
	private String roleDesc;
	private Integer status;
	private Boolean issys;
	@JsonBackReference
	private Set resources = new HashSet(0);
	@JsonBackReference
	private Set users = new HashSet(0);
	@JsonBackReference
	private List<Resource> resourcelist = new LinkedList<Resource>();

	public Role() {
	}

	public Role(String roleId) {
		this.roleId = roleId;
	}

	public Role(String roleId, String roleName, String roleDesc,
			Integer status, Boolean issys, Set resources, Set users) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.status = status;
		this.issys = issys;
		this.resources = resources;
		this.users = users;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIssys() {
		return this.issys;
	}

	public void setIssys(Boolean issys) {
		this.issys = issys;
	}

	public Set getResources() {
		return this.resources;
	}

	public void setResources(Set resources) {
		this.resources = resources;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public List<Resource> getResourcelist() {
		return resourcelist;
	}

	public void setResourcelist(List<Resource> resourcelist) {
		this.resourcelist = resourcelist;
	}

}
