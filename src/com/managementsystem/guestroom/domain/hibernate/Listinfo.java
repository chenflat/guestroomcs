package com.managementsystem.guestroom.domain.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 字典列表
 */
public class Listinfo implements java.io.Serializable {

	private static final long serialVersionUID = -7274532158869347700L;

	private String entryid;
	private Listinfo listinfo;
	private String listname;
	private String text;
	private String value;
	private Integer level;
	private Integer sortorder;
	private String definitionid;
	private String description;
	private Boolean systemlist;
	private String langcode;
	private String createdbyuserid;
	private Date createdondate;
	private String lastmodifiedbyuserId;
	private Date lastmodifiedondate;
	private Set listinfos = new HashSet(0);

	public Listinfo() {
	}

	public Listinfo(String entryid, String listname, String text, String value) {
		this.entryid = entryid;
		this.listname = listname;
		this.text = text;
		this.value = value;
	}

	public Listinfo(String entryid, Listinfo listinfo, String listname,
			String text, String value, Integer level, Integer sortorder,
			String definitionid, String description, Boolean systemlist,
			String createdbyuserid, Date createdondate,
			String lastmodifiedbyuserId, Date lastmodifiedondate, Set listinfos) {
		this.entryid = entryid;
		this.listinfo = listinfo;
		this.listname = listname;
		this.text = text;
		this.value = value;
		this.level = level;
		this.sortorder = sortorder;
		this.definitionid = definitionid;
		this.description = description;
		this.systemlist = systemlist;
		this.createdbyuserid = createdbyuserid;
		this.createdondate = createdondate;
		this.lastmodifiedbyuserId = lastmodifiedbyuserId;
		this.lastmodifiedondate = lastmodifiedondate;
		this.listinfos = listinfos;
	}

	public String getEntryid() {
		return this.entryid;
	}

	public void setEntryid(String entryid) {
		this.entryid = entryid;
	}

	public Listinfo getListinfo() {
		return this.listinfo;
	}

	public void setListinfo(Listinfo listinfo) {
		this.listinfo = listinfo;
	}

	public String getListname() {
		return this.listname;
	}

	public void setListname(String listname) {
		this.listname = listname;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSortorder() {
		return this.sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

	public String getDefinitionid() {
		return this.definitionid;
	}

	public void setDefinitionid(String definitionid) {
		this.definitionid = definitionid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSystemlist() {
		return this.systemlist;
	}

	public void setSystemlist(Boolean systemlist) {
		this.systemlist = systemlist;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
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

	public String getLastmodifiedbyuserId() {
		return this.lastmodifiedbyuserId;
	}

	public void setLastmodifiedbyuserId(String lastmodifiedbyuserId) {
		this.lastmodifiedbyuserId = lastmodifiedbyuserId;
	}

	public Date getLastmodifiedondate() {
		return this.lastmodifiedondate;
	}

	public void setLastmodifiedondate(Date lastmodifiedondate) {
		this.lastmodifiedondate = lastmodifiedondate;
	}

	public Set getListinfos() {
		return this.listinfos;
	}

	public void setListinfos(Set listinfos) {
		this.listinfos = listinfos;
	}

}
