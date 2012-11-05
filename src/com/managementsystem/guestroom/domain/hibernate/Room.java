package com.managementsystem.guestroom.domain.hibernate;

// Generated 2012-11-5 14:40:23 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Room generated by hbm2java
 */
public class Room implements java.io.Serializable {

	private String roomNo;
	private Floor floor;
	private Roomtype roomtype;
	private String roomName;
	private String roomTowards;
	private String roomPhone;
	private String roomFax;
	private String roomPhoto;
	private String roomComment;
	private Roomconfig roomconfig;
	private Set roomassignedgrouieses = new HashSet(0);

	public Room() {
	}

	public Room(String roomNo) {
		this.roomNo = roomNo;
	}

	public Room(String roomNo, Floor floor, Roomtype roomtype, String roomName,
			String roomTowards, String roomPhone, String roomFax,
			String roomPhoto, String roomComment, Roomconfig roomconfig,
			Set roomassignedgrouieses) {
		this.roomNo = roomNo;
		this.floor = floor;
		this.roomtype = roomtype;
		this.roomName = roomName;
		this.roomTowards = roomTowards;
		this.roomPhone = roomPhone;
		this.roomFax = roomFax;
		this.roomPhoto = roomPhoto;
		this.roomComment = roomComment;
		this.roomconfig = roomconfig;
		this.roomassignedgrouieses = roomassignedgrouieses;
	}

	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Floor getFloor() {
		return this.floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public Roomtype getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomTowards() {
		return this.roomTowards;
	}

	public void setRoomTowards(String roomTowards) {
		this.roomTowards = roomTowards;
	}

	public String getRoomPhone() {
		return this.roomPhone;
	}

	public void setRoomPhone(String roomPhone) {
		this.roomPhone = roomPhone;
	}

	public String getRoomFax() {
		return this.roomFax;
	}

	public void setRoomFax(String roomFax) {
		this.roomFax = roomFax;
	}

	public String getRoomPhoto() {
		return this.roomPhoto;
	}

	public void setRoomPhoto(String roomPhoto) {
		this.roomPhoto = roomPhoto;
	}

	public String getRoomComment() {
		return this.roomComment;
	}

	public void setRoomComment(String roomComment) {
		this.roomComment = roomComment;
	}

	public Roomconfig getRoomconfig() {
		return this.roomconfig;
	}

	public void setRoomconfig(Roomconfig roomconfig) {
		this.roomconfig = roomconfig;
	}

	public Set getRoomassignedgrouieses() {
		return this.roomassignedgrouieses;
	}

	public void setRoomassignedgrouieses(Set roomassignedgrouieses) {
		this.roomassignedgrouieses = roomassignedgrouieses;
	}

}
