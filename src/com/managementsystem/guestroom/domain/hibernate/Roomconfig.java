package com.managementsystem.guestroom.domain.hibernate;

public class Roomconfig implements java.io.Serializable {

	private static final long serialVersionUID = -1954541896518750320L;
	private int roomId;
	private Room room;
	private String roomIp;
	private Integer roomPort;

	public Roomconfig() {
	}

	public Roomconfig(Room room) {
		this.room = room;
	}

	public Roomconfig(Room room, String roomIp, Integer roomPort) {
		this.room = room;
		this.roomIp = roomIp;
		this.roomPort = roomPort;
	}

	public int getRoomId() {
		return this.roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getRoomIp() {
		return this.roomIp;
	}

	public void setRoomIp(String roomIp) {
		this.roomIp = roomIp;
	}

	public Integer getRoomPort() {
		return this.roomPort;
	}

	public void setRoomPort(Integer roomPort) {
		this.roomPort = roomPort;
	}

}
