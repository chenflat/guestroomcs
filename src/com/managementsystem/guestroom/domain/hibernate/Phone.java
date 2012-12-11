package com.managementsystem.guestroom.domain.hibernate;


import java.util.Date;

/**
 * 用户电话
 * */
public class Phone implements java.io.Serializable {
	private static final long serialVersionUID = 4510531729111455311L;
	private String phoneId;
	private User user;
	private Date createdOnDate;
	private Date lastModifiedOnDate;
	private String number;
	private String extension;
	private Boolean primary;
	private String entryid;

	public Phone() {
	}

	public Phone(String phoneId) {
		this.phoneId = phoneId;
	}

	public Phone(String phoneId, User user, Date createdOnDate,
			Date lastModifiedOnDate, String number, String extension,
			Boolean primary, String entryid) {
		this.phoneId = phoneId;
		this.user = user;
		this.createdOnDate = createdOnDate;
		this.lastModifiedOnDate = lastModifiedOnDate;
		this.number = number;
		this.extension = extension;
		this.primary = primary;
		this.entryid = entryid;
	}

	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedOnDate() {
		return this.createdOnDate;
	}

	public void setCreatedOnDate(Date createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public Date getLastModifiedOnDate() {
		return this.lastModifiedOnDate;
	}

	public void setLastModifiedOnDate(Date lastModifiedOnDate) {
		this.lastModifiedOnDate = lastModifiedOnDate;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Boolean getPrimary() {
		return this.primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public String getEntryid() {
		return this.entryid;
	}

	public void setEntryid(String entryid) {
		this.entryid = entryid;
	}

}
