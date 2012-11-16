package com.managementsystem.guestroom.domain.hibernate;

import java.util.List;

public class RoomgroupForm implements java.io.Serializable {

	private static final long serialVersionUID = -4849090584128891805L;
	List<Roomgroup> roomgroups;

	public List<Roomgroup> getRoomgroups() {
		return roomgroups;
	}

	public void setRoomgroups(List<Roomgroup> roomgroups) {
		this.roomgroups = roomgroups;
	}

}
