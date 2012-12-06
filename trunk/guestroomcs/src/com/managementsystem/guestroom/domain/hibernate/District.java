package com.managementsystem.guestroom.domain.hibernate;

import java.util.HashSet;
import java.util.Set;

public class District implements java.io.Serializable {

	private static final long serialVersionUID = 6856713698921462807L;
	private String districtId;
	private District district;
	private String districtName;
	private String districtPinyi;
	private String districtPostcode;
	private String districtAreacode;
	private String districtWoeid;
	private String districtComment;
	private Set districts = new HashSet(0);

	public District() {
	}

	public District(String districtId) {
		this.districtId = districtId;
	}

	public District(String districtId, District district, String districtName,
			String districtPinyi, String districtPostcode,
			String districtAreacode, String districtWoeid,
			String districtComment, Set districts) {
		this.districtId = districtId;
		this.district = district;
		this.districtName = districtName;
		this.districtPinyi = districtPinyi;
		this.districtPostcode = districtPostcode;
		this.districtAreacode = districtAreacode;
		this.districtWoeid = districtWoeid;
		this.districtComment = districtComment;
		this.districts = districts;
	}

	public String getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictPinyi() {
		return this.districtPinyi;
	}

	public void setDistrictPinyi(String districtPinyi) {
		this.districtPinyi = districtPinyi;
	}

	public String getDistrictPostcode() {
		return this.districtPostcode;
	}

	public void setDistrictPostcode(String districtPostcode) {
		this.districtPostcode = districtPostcode;
	}

	public String getDistrictAreacode() {
		return this.districtAreacode;
	}

	public void setDistrictAreacode(String districtAreacode) {
		this.districtAreacode = districtAreacode;
	}

	public String getDistrictWoeid() {
		return this.districtWoeid;
	}

	public void setDistrictWoeid(String districtWoeid) {
		this.districtWoeid = districtWoeid;
	}

	public String getDistrictComment() {
		return this.districtComment;
	}

	public void setDistrictComment(String districtComment) {
		this.districtComment = districtComment;
	}

	public Set getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set districts) {
		this.districts = districts;
	}

}
