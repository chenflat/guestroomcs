package com.managementsystem.util.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.managementsystem.guestroom.domain.platform.Roomcounter;
import com.managementsystem.guestroom.domain.platform.Roomview;
import com.managementsystem.guestroom.service.biz.RequestService;
import com.managementsystem.guestroom.service.biz.impl.RequestServiceImpl;
import com.managementsystem.util.net.RequestServiceProcess;
import com.managementsystem.util.net.RequestServiceUtil;

public class RequestServiceProcessTest {

	public static void main(String[] args) {

		// getRoomViews();
		// getRoomcounter();
		// getRoomcounter1();

		URL filepath = RequestService.class.getClassLoader().getResource("");

		try {
			String path = URLDecoder.decode(filepath.toString(), "utf-8");
			System.out.println(path);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * System.out.println(Thread.currentThread().getContextClassLoader()
		 * .getResource(""));
		 */

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
		try {
			roomcounter = rs.getRoomcounter();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roomcounter;
	}

}
