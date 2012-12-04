package com.managementsystem.guestroom.domain.platform;

/**
 * 房间设备运行历史记录
 * 
 * @author ping.chen
 * */
public class Histroylog implements java.io.Serializable {

	private static final long serialVersionUID = -111468835633735899L;

	private String roomNo;
	private Integer p;
	private String time;
	private String val;

	/**
	 * 获取房间编号
	 * */
	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	/**
	 * 返回(参数序号 0=设定温度 1=温度 2=风扇转速 3=阀门...)
	 * */
	public Integer getP() {
		return p;
	}

	public void setP(Integer p) {
		this.p = p;
	}

	/**
	 * 运行时间
	 * */
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * 数据值
	 * */
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "{\"roomNo\":\"" + this.roomNo + "\",\"p\":\"" + this.p
				+ "\",\"time\":\"" + this.time + "\",\"val\":\"" + this.val
				+ "\"}";
	}

}
