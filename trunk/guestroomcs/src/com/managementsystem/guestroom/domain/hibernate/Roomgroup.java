package com.managementsystem.guestroom.domain.hibernate;


import java.util.HashSet;
import java.util.Set;

/**
 * 房间组
 * */
public class Roomgroup implements java.io.Serializable {
	private static final long serialVersionUID = -8959639150478462238L;
	private String roomgroupId;
	private String roomgroupName;
	private String roomgroupDesc;
	private Integer sortOrder;
	private Set roomassignedgrouieses = new HashSet(0);

	public Roomgroup() {
	}

	public Roomgroup(String roomgroupId) {
		this.roomgroupId = roomgroupId;
	}

	public Roomgroup(String roomgroupId, String roomgroupName,
			String roomgroupDesc, Set roomassignedgrouieses) {
		this.roomgroupId = roomgroupId;
		this.roomgroupName = roomgroupName;
		this.roomgroupDesc = roomgroupDesc;
		this.roomassignedgrouieses = roomassignedgrouieses;
	}

	public String getRoomgroupId() {
		return this.roomgroupId;
	}

	public void setRoomgroupId(String roomgroupId) {
		this.roomgroupId = roomgroupId;
	}

	public String getRoomgroupName() {
		return this.roomgroupName;
	}

	public void setRoomgroupName(String roomgroupName) {
		this.roomgroupName = roomgroupName;
	}

	public String getRoomgroupDesc() {
		return this.roomgroupDesc;
	}

	public void setRoomgroupDesc(String roomgroupDesc) {
		this.roomgroupDesc = roomgroupDesc;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Set getRoomassignedgrouieses() {
		return this.roomassignedgrouieses;
	}

	public void setRoomassignedgrouieses(Set roomassignedgrouieses) {
		this.roomassignedgrouieses = roomassignedgrouieses;
	}

}
