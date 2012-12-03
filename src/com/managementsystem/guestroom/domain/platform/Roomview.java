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
	public String roomNo;
	public String rentState;
	public String tempSet;
	public String temp;
	public String fanSpeed;
	public String val;
	public String fanAuto;
	public String season;
	public String fanPower;

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

	public String getTempSet() {
		return tempSet;
	}

	public void setTempSet(String tempSet) {
		this.tempSet = tempSet;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getFanSpeed() {
		return fanSpeed;
	}

	public void setFanSpeed(String fanSpeed) {
		this.fanSpeed = fanSpeed;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getFanAuto() {
		return fanAuto;
	}

	public void setFanAuto(String fanAuto) {
		this.fanAuto = fanAuto;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getFanPower() {
		return fanPower;
	}

	public void setFanPower(String fanPower) {
		this.fanPower = fanPower;
	}

	@Override
	public String toString() {

		return "{\"roomNo\":\"" + this.roomNo + "\",\"rentState\":\""
				+ this.rentState + "\",\"tempSet\":\"" + this.tempSet
				+ "\",\"temp\":\"" + this.temp + "\",\"fanSpeed\":\""
				+ this.fanSpeed + "\",\"val\":\"" + this.val
				+ "\",\"fanAuto\":\"" + this.fanAuto + "\",\"season\":\""
				+ this.season + "\",\"fanPower\":\"" + this.fanPower + "\"}";
	}

}
