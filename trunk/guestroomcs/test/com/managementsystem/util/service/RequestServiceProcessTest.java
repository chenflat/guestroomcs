package com.managementsystem.util.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.managementsystem.guestroom.domain.platform.Roomcounter;
import com.managementsystem.guestroom.domain.platform.Roomview;
import com.managementsystem.guestroom.service.biz.RequestService;
import com.managementsystem.guestroom.service.biz.impl.RequestServiceImpl;

public class RequestServiceProcessTest {

	public static void main(String[] args) {

		//getRoomViews();
		getRoomcounter();
		getRoomcounter1();
	}

	public static void getRoomViews() {
		String url = "http://localhost:8082/rd/roomview?type=12";
		RequestServiceProcess<Roomview> process = new RequestServiceProcess<Roomview>(
				new Roomview());
		try {
			List<Roomview> list = process.getRequestResult(url);
			for (Roomview rv : list) {
				System.out.println(rv.toString());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getRoomcounter() {
		String url = "http://localhost:8082/rd/statis/roomcounter";
		RequestServiceUtil<Roomcounter> process = new RequestServiceProcess<Roomcounter>(
				new Roomcounter());
		try {
			List<Roomcounter> list = process.getRequestResult(url);
			for (Roomcounter rc : list) {
				System.out.println(rc.toString());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Roomcounter getRoomcounter1() {
		Roomcounter roomcounter = new Roomcounter();
		RequestService rs = new RequestServiceImpl();
		roomcounter = rs.getRoomcounter();
		return roomcounter;
	}

}
