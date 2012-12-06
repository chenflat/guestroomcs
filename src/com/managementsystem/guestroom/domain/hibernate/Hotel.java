package com.managementsystem.guestroom.domain.hibernate;


import java.util.HashSet;
import java.util.Set;


public class Hotel implements java.io.Serializable {

	private static final long serialVersionUID = -3319726178365249301L;
	private String hotelId;
	private String hotelName;
	private String hotelEnname;
	private String hotelDesc;
	private String currency;
	private String hotelAddress;
	private String hotelDistrict;
	private String hotelCity;
	private String hotelState;
	private String hotelCountry;
	private String hotelZip;
	private String hotelPhone;
	private String hotelFax;
	private String hotelEmail;
	private String hotelPhoto;
	private String hotelLong;
	private String hotelLat;
	private String hotelComment;
	private Set builds = new HashSet(0);
	private Set roomtypes = new HashSet(0);
	private Set departments = new HashSet(0);

	public Hotel() {
	}

	public Hotel(String hotelId) {
		this.hotelId = hotelId;
	}

	public Hotel(String hotelId, String hotelName, String hotelEnname,
			String hotelDesc, String currency, String hotelAddress,
			String hotelDistrict, String hotelCity, String hotelState,
			String hotelCountry, String hotelZip, String hotelPhone,
			String hotelFax, String hotelEmail, String hotelPhoto,
			String hotelLong, String hotelLat, String hotelComment, Set builds,
			Set roomtypes, Set departments) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelEnname = hotelEnname;
		this.hotelDesc = hotelDesc;
		this.currency = currency;
		this.hotelAddress = hotelAddress;
		this.hotelDistrict = hotelDistrict;
		this.hotelCity = hotelCity;
		this.hotelState = hotelState;
		this.hotelCountry = hotelCountry;
		this.hotelZip = hotelZip;
		this.hotelPhone = hotelPhone;
		this.hotelFax = hotelFax;
		this.hotelEmail = hotelEmail;
		this.hotelPhoto = hotelPhoto;
		this.hotelLong = hotelLong;
		this.hotelLat = hotelLat;
		this.hotelComment = hotelComment;
		this.builds = builds;
		this.roomtypes = roomtypes;
		this.departments = departments;
	}

	public String getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelEnname() {
		return this.hotelEnname;
	}

	public void setHotelEnname(String hotelEnname) {
		this.hotelEnname = hotelEnname;
	}

	public String getHotelDesc() {
		return this.hotelDesc;
	}

	public void setHotelDesc(String hotelDesc) {
		this.hotelDesc = hotelDesc;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getHotelAddress() {
		return this.hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelDistrict() {
		return this.hotelDistrict;
	}

	public void setHotelDistrict(String hotelDistrict) {
		this.hotelDistrict = hotelDistrict;
	}

	public String getHotelCity() {
		return this.hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelState() {
		return this.hotelState;
	}

	public void setHotelState(String hotelState) {
		this.hotelState = hotelState;
	}

	public String getHotelCountry() {
		return this.hotelCountry;
	}

	public void setHotelCountry(String hotelCountry) {
		this.hotelCountry = hotelCountry;
	}

	public String getHotelZip() {
		return this.hotelZip;
	}

	public void setHotelZip(String hotelZip) {
		this.hotelZip = hotelZip;
	}

	public String getHotelPhone() {
		return this.hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public String getHotelFax() {
		return this.hotelFax;
	}

	public void setHotelFax(String hotelFax) {
		this.hotelFax = hotelFax;
	}

	public String getHotelEmail() {
		return this.hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getHotelPhoto() {
		return this.hotelPhoto;
	}

	public void setHotelPhoto(String hotelPhoto) {
		this.hotelPhoto = hotelPhoto;
	}

	public String getHotelLong() {
		return this.hotelLong;
	}

	public void setHotelLong(String hotelLong) {
		this.hotelLong = hotelLong;
	}

	public String getHotelLat() {
		return this.hotelLat;
	}

	public void setHotelLat(String hotelLat) {
		this.hotelLat = hotelLat;
	}

	public String getHotelComment() {
		return this.hotelComment;
	}

	public void setHotelComment(String hotelComment) {
		this.hotelComment = hotelComment;
	}

	public Set getBuilds() {
		return this.builds;
	}

	public void setBuilds(Set builds) {
		this.builds = builds;
	}

	public Set getRoomtypes() {
		return this.roomtypes;
	}

	public void setRoomtypes(Set roomtypes) {
		this.roomtypes = roomtypes;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

}
