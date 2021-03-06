package com.managementsystem.guestroom.domain.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Portal implements java.io.Serializable {

	private static final long serialVersionUID = 5515461058156454148L;
	private String portalId;
	private String portalName;
	private String portalEnname;
	private String portalDesc;
	private String copyright;
	private Date expirydate;
	private String administratorid;
	private String administratorroleid;
	private String registeredroleid;
	private Integer timezoneoffset;
	private String defaultlanguage;
	private String currency;
	private String hosturl;
	private String createdbyuserid;
	private Date createdondate;
	private String lastmodifiedbyuserid;
	private Date lastmodifiedondate;
	private Set portalsettingses = new HashSet(0);

	public Portal() {
	}

	public Portal(String portalId) {
		this.portalId = portalId;
	}

	public Portal(String portalId, String portalName, String portalEnname,
			String portalDesc, String copyright, Date expirydate,
			String administratorid, String administratorroleid,
			String registeredroleid, Integer timezoneoffset,
			String defaultlanguage, String currency, String createdbyuserid,
			Date createdondate, String lastmodifiedbyuserid,
			Date lastmodifiedondate, Set portalsettingses) {
		this.portalId = portalId;
		this.portalName = portalName;
		this.portalEnname = portalEnname;
		this.portalDesc = portalDesc;
		this.copyright = copyright;
		this.expirydate = expirydate;
		this.administratorid = administratorid;
		this.administratorroleid = administratorroleid;
		this.registeredroleid = registeredroleid;
		this.timezoneoffset = timezoneoffset;
		this.defaultlanguage = defaultlanguage;
		this.currency = currency;
		this.createdbyuserid = createdbyuserid;
		this.createdondate = createdondate;
		this.lastmodifiedbyuserid = lastmodifiedbyuserid;
		this.lastmodifiedondate = lastmodifiedondate;
		this.portalsettingses = portalsettingses;
	}

	public String getPortalId() {
		return this.portalId;
	}

	public void setPortalId(String portalId) {
		this.portalId = portalId;
	}

	public String getPortalName() {
		return this.portalName;
	}

	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}

	public String getPortalEnname() {
		return this.portalEnname;
	}

	public void setPortalEnname(String portalEnname) {
		this.portalEnname = portalEnname;
	}

	public String getPortalDesc() {
		return this.portalDesc;
	}

	public void setPortalDesc(String portalDesc) {
		this.portalDesc = portalDesc;
	}

	public String getCopyright() {
		return this.copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Date getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getAdministratorid() {
		return this.administratorid;
	}

	public void setAdministratorid(String administratorid) {
		this.administratorid = administratorid;
	}

	public String getAdministratorroleid() {
		return this.administratorroleid;
	}

	public void setAdministratorroleid(String administratorroleid) {
		this.administratorroleid = administratorroleid;
	}

	public String getRegisteredroleid() {
		return this.registeredroleid;
	}

	public void setRegisteredroleid(String registeredroleid) {
		this.registeredroleid = registeredroleid;
	}

	public Integer getTimezoneoffset() {
		return this.timezoneoffset;
	}

	public void setTimezoneoffset(Integer timezoneoffset) {
		this.timezoneoffset = timezoneoffset;
	}

	public String getDefaultlanguage() {
		return this.defaultlanguage;
	}

	public void setDefaultlanguage(String defaultlanguage) {
		this.defaultlanguage = defaultlanguage;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getHosturl() {
		return hosturl;
	}

	public void setHosturl(String hosturl) {
		this.hosturl = hosturl;
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

	public Set getPortalsettingses() {
		return this.portalsettingses;
	}

	public void setPortalsettingses(Set portalsettingses) {
		this.portalsettingses = portalsettingses;
	}

}
