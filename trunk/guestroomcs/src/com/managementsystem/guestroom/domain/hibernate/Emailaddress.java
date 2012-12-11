package com.managementsystem.guestroom.domain.hibernate;


import java.util.Date;

/**
 * 用户电子邮件
 * */
public class Emailaddress implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String emailAddressId;
	private User user;
	private Date createdOnDate;
	private Date lastModifiedOnDate;
	private String address;
	private Boolean primary;
	private String entryid;

	public Emailaddress() {
	}

	public Emailaddress(String emailAddressId) {
		this.emailAddressId = emailAddressId;
	}

	public Emailaddress(String emailAddressId, User user, Date createdOnDate,
			Date lastModifiedOnDate, String address, Boolean primary,
			String entryid) {
		this.emailAddressId = emailAddressId;
		this.user = user;
		this.createdOnDate = createdOnDate;
		this.lastModifiedOnDate = lastModifiedOnDate;
		this.address = address;
		this.primary = primary;
		this.entryid = entryid;
	}

	public String getEmailAddressId() {
		return this.emailAddressId;
	}

	public void setEmailAddressId(String emailAddressId) {
		this.emailAddressId = emailAddressId;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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
