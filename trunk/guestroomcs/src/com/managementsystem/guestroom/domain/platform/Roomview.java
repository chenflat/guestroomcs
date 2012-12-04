package com.managementsystem.guestroom.domain.platform;

/**
 * 客房视图
 * <p>
 * (可任意组合 1=服务请求 2=SOS 4=出租状态 8=HVAC 16=通讯故障 32=能耗)
 * </p>
 * 
 * @author ping.chen 03/12/2012
 * @version 1.0
 * */
public class Roomview implements java.io.Serializable {

	private static final long serialVersionUID = -8885527759767322443L;
	
	public String roomNo;
	public String rentState;
	public String tempSet0;
	public String temp0;
	public String fanSpeed0;
	public String val0;
	public String fanAuto0;
	public String season0;
	public String fanPower0;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRentState() {
		return rentState;
	}

	public void setRentState(String rentState) {
		this.rentState = rentState;
	}

	
	public String getTempSet0() {
		return tempSet0;
	}

	public void setTempSet0(String tempSet0) {
		this.tempSet0 = tempSet0;
	}

	public String getTemp0() {
		return temp0;
	}

	public void setTemp0(String temp0) {
		this.temp0 = temp0;
	}

	public String getFanSpeed0() {
		return fanSpeed0;
	}

	public void setFanSpeed0(String fanSpeed0) {
		this.fanSpeed0 = fanSpeed0;
	}

	public String getVal0() {
		return val0;
	}

	public void setVal0(String val0) {
		this.val0 = val0;
	}

	public String getFanAuto0() {
		return fanAuto0;
	}

	public void setFanAuto0(String fanAuto0) {
		this.fanAuto0 = fanAuto0;
	}

	public String getSeason0() {
		return season0;
	}

	public void setSeason0(String season0) {
		this.season0 = season0;
	}

	public String getFanPower0() {
		return fanPower0;
	}

	public void setFanPower0(String fanPower0) {
		this.fanPower0 = fanPower0;
	}

	@Override
	public String toString() {

		return "{\"roomNo\":\"" + this.roomNo + "\",\"rentState\":\""
				+ this.rentState + "\",\"tempSet\":\"" + this.tempSet0
				+ "\",\"temp\":\"" + this.temp0 + "\",\"fanSpeed\":\""
				+ this.fanSpeed0 + "\",\"val\":\"" + this.val0
				+ "\",\"fanAuto\":\"" + this.fanAuto0 + "\",\"season\":\""
				+ this.season0 + "\",\"fanPower\":\"" + this.fanPower0 + "\"}";
	}

}
