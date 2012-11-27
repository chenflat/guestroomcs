package com.managementsystem.guestroom.domain.hibernate;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Profilepropertydefinition implements java.io.Serializable {
	private static final long serialVersionUID = 1882390158145886280L;
	private String propertydefinitionid;
	private Boolean deleted;
	private Integer datatype;
	private String defaultvalue;
	private String propertycategory;
	private String propertyname;
	private Integer length;
	private Boolean required;
	private String validationexpression;
	private Integer vieworder;
	private Boolean visible;
	private Integer defaultvisibility;
	private String createdbyuserid;
	private Date createdondate;
	private String lastmodifiedbyuserid;
	private Date lastmodifiedondate;
	private Set userprofiles = new HashSet(0);

	public Profilepropertydefinition() {
	}

	public Profilepropertydefinition(String propertydefinitionid) {
		this.propertydefinitionid = propertydefinitionid;
	}

	public Profilepropertydefinition(String propertydefinitionid,
			Boolean deleted, Integer datatype, String defaultvalue,
			String propertycategory, String propertyname, Integer length,
			Boolean required, String validationexpression, Integer vieworder,
			Boolean visible, Integer defaultvisibility, String createdbyuserid,
			Date createdondate, String lastmodifiedbyuserid,
			Date lastmodifiedondate, Set userprofiles) {
		this.propertydefinitionid = propertydefinitionid;
		this.deleted = deleted;
		this.datatype = datatype;
		this.defaultvalue = defaultvalue;
		this.propertycategory = propertycategory;
		this.propertyname = propertyname;
		this.length = length;
		this.required = required;
		this.validationexpression = validationexpression;
		this.vieworder = vieworder;
		this.visible = visible;
		this.defaultvisibility = defaultvisibility;
		this.createdbyuserid = createdbyuserid;
		this.createdondate = createdondate;
		this.lastmodifiedbyuserid = lastmodifiedbyuserid;
		this.lastmodifiedondate = lastmodifiedondate;
		this.userprofiles = userprofiles;
	}

	public String getPropertydefinitionid() {
		return this.propertydefinitionid;
	}

	public void setPropertydefinitionid(String propertydefinitionid) {
		this.propertydefinitionid = propertydefinitionid;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getDatatype() {
		return this.datatype;
	}

	public void setDatatype(Integer datatype) {
		this.datatype = datatype;
	}

	public String getDefaultvalue() {
		return this.defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public String getPropertycategory() {
		return this.propertycategory;
	}

	public void setPropertycategory(String propertycategory) {
		this.propertycategory = propertycategory;
	}

	public String getPropertyname() {
		return this.propertyname;
	}

	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Boolean getRequired() {
		return this.required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getValidationexpression() {
		return this.validationexpression;
	}

	public void setValidationexpression(String validationexpression) {
		this.validationexpression = validationexpression;
	}

	public Integer getVieworder() {
		return this.vieworder;
	}

	public void setVieworder(Integer vieworder) {
		this.vieworder = vieworder;
	}

	public Boolean getVisible() {
		return this.visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Integer getDefaultvisibility() {
		return this.defaultvisibility;
	}

	public void setDefaultvisibility(Integer defaultvisibility) {
		this.defaultvisibility = defaultvisibility;
	}

	public String getCreatedbyuserid() {
		return this.createdbyuserid;
	}

	public void setCreatedbyuserid(String createdbyuserid) {
		this.createdbyuserid = createdbyuserid;
	}

	public Date getCreatedondate() {
		return this.createdondate;
	}

	public void setCreatedondate(Date createdondate) {
		this.createdondate = createdondate;
	}

	public String getLastmodifiedbyuserid() {
		return this.lastmodifiedbyuserid;
	}

	public void setLastmodifiedbyuserid(String lastmodifiedbyuserid) {
		this.lastmodifiedbyuserid = lastmodifiedbyuserid;
	}

	public Date getLastmodifiedondate() {
		return this.lastmodifiedondate;
	}

	public void setLastmodifiedondate(Date lastmodifiedondate) {
		this.lastmodifiedondate = lastmodifiedondate;
	}

	public Set getUserprofiles() {
		return this.userprofiles;
	}

	public void setUserprofiles(Set userprofiles) {
		this.userprofiles = userprofiles;
	}

}
