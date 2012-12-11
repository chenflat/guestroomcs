package com.managementsystem.guestroom.domain.hibernate;


import java.util.Date;

/**
 * 用户地址
 */
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String addressId;
	private User user;
	private Date createdOnDate;
	private Date lastModifiedOnDate;
	private String state;
	private String city;
	private String street;
	private String zipcode;
	private String country;
	private Boolean primary;
	private String entryid;

	public Address() {
	}

	public Address(String addressId) {
		this.addressId = addressId;
	}

	public Address(String addressId, User user, Date createdOnDate,
			Date lastModifiedOnDate, String state, String city, String street,
			String zipcode, String country, Boolean primary, String entryid) {
		this.addressId = addressId;
		this.user = user;
		this.createdOnDate = createdOnDate;
		this.lastModifiedOnDate = lastModifiedOnDate;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.country = country;
		this.primary = primary;
		this.entryid = entryid;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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
