package com.managementsystem.guestroom.domain.hibernate;

// Generated 2012-11-6 13:37:38 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Floor generated by hbm2java
 */
public class Floor implements java.io.Serializable {

	private String floorId;
	private Build build;
	private String floorNo;
	private String floorName;
	private String floorComment;
	private Set rooms = new LinkedHashSet(0);

	public Floor() {
	}

	public Floor(String floorId) {
		this.floorId = floorId;
	}

	public Floor(String floorId, Build build, String floorNo, String floorName,
			String floorComment, Set rooms) {
		this.floorId = floorId;
		this.build = build;
		this.floorNo = floorNo;
		this.floorName = floorName;
		this.floorComment = floorComment;
		this.rooms = rooms;
	}

	public String getFloorId() {
		return this.floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public Build getBuild() {
		return this.build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public String getFloorNo() {
		return this.floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getFloorName() {
		return this.floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getFloorComment() {
		return this.floorComment;
	}

	public void setFloorComment(String floorComment) {
		this.floorComment = floorComment;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

}
