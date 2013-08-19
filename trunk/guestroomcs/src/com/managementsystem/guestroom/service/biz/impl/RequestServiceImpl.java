package com.managementsystem.guestroom.service.biz.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.managementsystem.guestroom.domain.platform.Histroylog;
import com.managementsystem.guestroom.domain.platform.Roomcounter;
import com.managementsystem.guestroom.service.biz.RequestService;
import com.managementsystem.util.OrderedProperties;
import com.managementsystem.util.net.RequestServiceProcess;
import com.managementsystem.util.net.RequestServiceUtil;

@Service
public class RequestServiceImpl implements RequestService {

	private Properties props;
	private String hostUrl;
	private String roomcounterUrl;
	private String roomviewUrl;
	private String clearserviceUrl;
	private String setvalueUrl;
	private String queryprocessUrl;
	private String queryrecordsetUrl;
	private String synctimeUrl;
	private String checkinUrl;

	public RequestServiceImpl() {
		try {
			// 载入属性文件流
			InputStream inStream = RequestService.class.getClassLoader()
					.getResourceAsStream(RequestService.PROPERTYFILE);
			props = new OrderedProperties();
			props.load(inStream);
			inStream.close();
			// 获取属性值
			hostUrl = props.getProperty(RequestService.HOSTURL);
			roomcounterUrl = hostUrl
					+ props.getProperty(RequestService.ROOMCOUNTER);
			roomviewUrl = hostUrl + props.getProperty(RequestService.ROOMVIEW);
			clearserviceUrl = hostUrl
					+ props.getProperty(RequestService.CLEARSERVICE);
			setvalueUrl = hostUrl + props.getProperty(RequestService.SETVALUE);
			queryprocessUrl = hostUrl
					+ props.getProperty(RequestService.QUERYPROCESS);
			queryrecordsetUrl = hostUrl
					+ props.getProperty(RequestService.QUERYRECORDSET);
			synctimeUrl = hostUrl + props.getProperty(RequestService.SYNCTIME);
			
			checkinUrl = hostUrl + props.getProperty(RequestService.CHECKIN);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Roomcounter getRoomcounter() throws MalformedURLException,
			IOException {
		Roomcounter roomcounter = new Roomcounter();
		RequestServiceUtil<Roomcounter> process = new RequestServiceProcess<Roomcounter>(
				roomcounter);
		List<Roomcounter> list = process.getRequestResult(roomcounterUrl);
		if (list != null && list.size() > 0) {
			roomcounter = list.get(0);
		}
		return roomcounter;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Map<String, String>> getRoomviews(int type)
			throws MalformedURLException, IOException {
		Assert.notNull(type, "'type' must not be null");
		Map<String, String> map = new HashMap<String, String>();

		RequestServiceProcess<Map<String, String>> process = new RequestServiceProcess<Map<String, String>>(
				map);
		List<Map<String, String>> list = null;
		String serviceUrl = String.format(roomviewUrl + "?type=%s", type);
		list = process.getRequestResult(serviceUrl);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Map<String, String>> clearService(String roomNo, int type)
			throws MalformedURLException, IOException {
		Assert.notNull(roomNo, "'roomNo' must not be null");
		Assert.notNull(type, "'type' must not be null");

		Map<String, String> map = new HashMap<String, String>();
		RequestServiceProcess<Map<String, String>> process = new RequestServiceProcess<Map<String, String>>(
				map);
		List<Map<String, String>> list = null;
		String serviceUrl = String.format(clearserviceUrl
				+ "?roomNo=%s&type=%s", roomNo, type);
		list = process.getRequestResult(serviceUrl);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Map<String, String>> setValue(String roomNo,String tempControllerIndex, String value)
			throws MalformedURLException, IOException {
		Assert.notNull(roomNo, "'roomNo' must not be null");
		Assert.notNull(tempControllerIndex, "'p' must not be null");
		Assert.notNull(value, "'value' must not be null");
		Map<String, String> map = new HashMap<String, String>();
		RequestServiceProcess<Map<String, String>> process = new RequestServiceProcess<Map<String, String>>(
				map);
		List<Map<String, String>> list = null;
		String serviceUrl = String.format(setvalueUrl
				+ "?roomNo=%s&p=%s&value=%s", roomNo, tempControllerIndex,value);
		list = process.getRequestResult(serviceUrl);
	
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Histroylog> query(Map<String, String> parameters)
			throws MalformedURLException, IOException {
		Histroylog histroylog = new Histroylog();
		RequestServiceProcess<Histroylog> process = new RequestServiceProcess<Histroylog>(
				histroylog);
		List<Histroylog> list = null;
		StringBuilder sb = new StringBuilder();
		if (parameters != null && parameters.size() > 0) {
			for (Iterator<Entry<String, String>> it = parameters.entrySet()
					.iterator(); it.hasNext();) {
				Entry<String, String> entry = it.next();
				if (sb.length() > 0) {
					sb.append("&");
				}
				sb.append(String.format("%s=%s", entry.getKey(),
						entry.getValue()));
			}
		} else {
			throw new IllegalStateException(
					"Unable to peek ahead in non-empty collection - no element found");
		}
		String serviceUrl = String
				.format(queryprocessUrl + "?" + sb.toString());
		list = process.getRequestResult(serviceUrl);

		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Histroylog> queryHistory(Map<String, String> parameters)
			throws MalformedURLException, IOException {
		Histroylog histroylog = new Histroylog();
		RequestServiceProcess<Histroylog> process = new RequestServiceProcess<Histroylog>(
				histroylog);
		List<Histroylog> list = null;
		StringBuilder sb = new StringBuilder();
		if (parameters != null && parameters.size() > 0) {
			for (Iterator<Entry<String, String>> it = parameters.entrySet()
					.iterator(); it.hasNext();) {
				Entry<String, String> entry = it.next();
				if (sb.length() > 0) {
					sb.append("&");
				}
				sb.append(String.format("%s=%s", entry.getKey(),
						entry.getValue()));
			}
		} else {
			throw new IllegalStateException(
					"Unable to peek ahead in non-empty collection - no element found");
		}
		String serviceUrl = String.format(queryrecordsetUrl + "?"
				+ sb.toString());
		list = process.getRequestResult(serviceUrl);

		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Map<String, String>> synctime() throws MalformedURLException,
			IOException {
		// synctimeUrl
		Map<String, String> map = new HashMap<String, String>();
		RequestServiceProcess<Map<String, String>> process = new RequestServiceProcess<Map<String, String>>(
				map);
		List<Map<String, String>> list = null;
		list = process.getRequestResult(synctimeUrl);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Map<String, String>> checkIn(String roomNo, String guestName,
			String language, String tempSet) throws MalformedURLException,
			IOException {
		Assert.notNull(roomNo, "'roomNo' must not be null");
		Assert.notNull(tempSet, "'tempSet' must not be null");
		Map<String, String> map = new HashMap<String, String>();
		RequestServiceProcess<Map<String, String>> process = new RequestServiceProcess<Map<String, String>>(
				map);
		List<Map<String, String>> list = null;
		String serviceUrl = String.format(checkinUrl
				+ "?roomNo=%s&guestName=%s&Language=%s&tempSet=%s", roomNo, guestName,language,tempSet);
		list = process.getRequestResult(serviceUrl);
	
		return list;
	}

	
	
}
