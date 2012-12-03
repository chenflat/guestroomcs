package com.managementsystem.guestroom.domain.platform;

/**
 * 客房实时统计 <br />
 * 统计状态：总数/连接数/失去连接数/SOS数/有服务请求的房间数/待租数/出租数/退房中/空置数/预订数
 * 
 * @author ping.chen
 * */
public class Roomcounter implements java.io.Serializable {

	private static final long serialVersionUID = 4705463594017196654L;
	private Integer total;
	private Integer online;
	private Integer commerr;
	private Integer sos;
	private Integer reqServ;
	private Integer forRent;
	private Integer rent;
	private Integer checkout;
	private Integer vacant;
	private Integer book;

	/**
	 * 获取请求总数
	 * */
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * 获取连接数
	 * */
	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	/**
	 * 返回失去连接数
	 * */
	public Integer getCommerr() {
		return commerr;
	}

	public void setCommerr(Integer commerr) {
		this.commerr = commerr;
	}

	/**
	 * SOS请求数
	 * */
	public Integer getSos() {
		return sos;
	}

	public void setSos(Integer sos) {
		this.sos = sos;
	}

	/**
	 * 有服务请求的房间数
	 * */
	public Integer getReqServ() {
		return reqServ;
	}

	public void setReqServ(Integer reqServ) {
		this.reqServ = reqServ;
	}

	/**
	 * 待租数
	 * */
	public Integer getForRent() {
		return forRent;
	}

	public void setForRent(Integer forRent) {
		this.forRent = forRent;
	}

	/**
	 * 获取出租数
	 * */
	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	/**
	 * 获取退房中
	 * */
	public Integer getCheckout() {
		return checkout;
	}

	public void setCheckout(Integer checkout) {
		this.checkout = checkout;
	}

	/**
	 * 获取空置数
	 * */
	public Integer getVacant() {
		return vacant;
	}

	public void setVacant(Integer vacant) {
		this.vacant = vacant;
	}

	/**
	 * 获取预订数
	 * */
	public Integer getBook() {
		return book;
	}

	public void setBook(Integer book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "\"total\":\"" + this.total + "\",\"online\":\"" + this.online
				+ "\",\"commerr\":\"" + this.commerr + "\",\"sos\":\""
				+ this.sos + "\",\"reqServ\":\"" + this.reqServ
				+ "\",\"forRent\":\"" + this.forRent + "\",\"rent\":\""
				+ this.rent + "\",\"checkout\":\"" + this.checkout
				+ "\",\"vacant\":\"" + this.vacant + "\",\"book\":\""
				+ this.book + "\"";
	}

}
