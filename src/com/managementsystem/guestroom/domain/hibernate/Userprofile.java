package com.managementsystem.guestroom.domain.hibernate;

import java.util.Date;

public class Userprofile implements java.io.Serializable {
	private static final long serialVersionUID = -1656560571024099586L;
	private String profileid;
	private User user;
	private Profilepropertydefinition profilepropertydefinition;
	private String propertyvalue;
	private String propertytext;
	private Integer visibility;
	private Date lastupdateddate;

	public Userprofile() {
	}

	public Userprofile(String profileid) {
		this.profileid = profileid;
	}

	public Userprofile(String profileid, User user,
			Profilepropertydefinition profilepropertydefinition,
			String propertyvalue, String propertytext, Integer visibility,
			Date lastupdateddate) {
		this.profileid = profileid;
		this.user = user;
		this.profilepropertydefinition = profilepropertydefinition;
		this.propertyvalue = propertyvalue;
		this.propertytext = propertytext;
		this.visibility = visibility;
		this.lastupdateddate = lastupdateddate;
	}

	public String getProfileid() {
		return this.profileid;
	}

	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profilepropertydefinition getProfilepropertydefinition() {
		return this.profilepropertydefinition;
	}

	public void setProfilepropertydefinition(
			Profilepropertydefinition profilepropertydefinition) {
		this.profilepropertydefinition = profilepropertydefinition;
	}

	public String getPropertyvalue() {
		return this.propertyvalue;
	}

	public void setPropertyvalue(String propertyvalue) {
		this.propertyvalue = propertyvalue;
	}

	public String getPropertytext() {
		return this.propertytext;
	}

	public void setPropertytext(String propertytext) {
		this.propertytext = propertytext;
	}

	public Integer getVisibility() {
		return this.visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	public Date getLastupdateddate() {
		return this.lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

}
