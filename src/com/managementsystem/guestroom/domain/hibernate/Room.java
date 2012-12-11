package com.managementsystem.guestroom.domain.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * 客房信息类
 * */
public class Room implements java.io.Serializable {

	private static final long serialVersionUID = 2525653015084863659L;
	private int roomId;
	private Floor floor;
	private Roomtype roomtype;
	private String roomNo;
	private String roomName;
	private String roomTowards;
	private String roomPhone;
	private String roomFax;
	private String roomPhoto;
	private String roomComment;
	private Boolean handicappedroom;
	private Boolean koshersabbath;
	private Integer status;
	private Roomconfig roomconfig;
	private Set roomassignedgrouieses = new HashSet(0);

	public Room() {
	}

	public Room(int roomId, String roomNo) {
		this.roomId = roomId;
		this.roomNo = roomNo;
	}

	public Room(int roomId, Floor floor, Roomtype roomtype, String roomNo,
			String roomName, String roomTowards, String roomPhone,
			String roomFax, String roomPhoto, String roomComment,
			Boolean handicappedroom, Boolean koshersabbath, Integer status,
			Roomconfig roomconfig, Set roomassignedgrouieses) {
		this.roomId = roomId;
		this.floor = floor;
		this.roomtype = roomtype;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.roomTowards = roomTowards;
		this.roomPhone = roomPhone;
		this.roomFax = roomFax;
		this.roomPhoto = roomPhoto;
		this.roomComment = roomComment;
		this.handicappedroom = handicappedroom;
		this.koshersabbath = koshersabbath;
		this.status = status;
		this.roomconfig = roomconfig;
		this.roomassignedgrouieses = roomassignedgrouieses;
	}

	public int getRoomId() {
		return this.roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
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

	public Boolean getHandicappedroom() {
		return this.handicappedroom;
	}

	public void setHandicappedroom(Boolean handicappedroom) {
		this.handicappedroom = handicappedroom;
	}

	public Boolean getKoshersabbath() {
		return this.koshersabbath;
	}

	public void setKoshersabbath(Boolean koshersabbath) {
		this.koshersabbath = koshersabbath;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
