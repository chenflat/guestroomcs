package com.managementsystem.guestroom.domain.hibernate;

import java.util.Date;

public class Shiftwork implements java.io.Serializable {

	private static final long serialVersionUID = 275671596830418991L;
	private long shiftworkId;
	private User user;
	private Date workStarttime;
	private Date workEndtime;
	private String shiftworker;
	private String shiftworkerName;
	private String floorNo;
	private Date createdOnDate;
	private String comment;

	public Shiftwork() {
	}

	public Shiftwork(long shiftworkId) {
		this.shiftworkId = shiftworkId;
	}

	public Shiftwork(long shiftworkId, User user, Date workStarttime,
			Date workEndtime, String shiftworker, String shiftworkerName,
			String floorNo, Date createdOnDate, String comment) {
		this.shiftworkId = shiftworkId;
		this.user = user;
		this.workStarttime = workStarttime;
		this.workEndtime = workEndtime;
		this.shiftworker = shiftworker;
		this.shiftworkerName = shiftworkerName;
		this.floorNo = floorNo;
		this.createdOnDate = createdOnDate;
		this.comment = comment;
	}

	public long getShiftworkId() {
		return this.shiftworkId;
	}

	public void setShiftworkId(long shiftworkId) {
		this.shiftworkId = shiftworkId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getWorkStarttime() {
		return this.workStarttime;
	}

	public void setWorkStarttime(Date workStarttime) {
		this.workStarttime = workStarttime;
	}

	public Date getWorkEndtime() {
		return this.workEndtime;
	}

	public void setWorkEndtime(Date workEndtime) {
		this.workEndtime = workEndtime;
	}

	public Date getCreatedOnDate() {
		return this.createdOnDate;
	}

	public void setCreatedOnDate(Date createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getShiftworker() {
		return shiftworker;
	}

	public void setShiftworker(String shiftworker) {
		this.shiftworker = shiftworker;
	}

	public String getShiftworkerName() {
		return shiftworkerName;
	}

	public void setShiftworkerName(String shiftworkerName) {
		this.shiftworkerName = shiftworkerName;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

}
