package com.managementsystem.guestroom.web.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.managementsystem.guestroom.service.biz.RequestService;

/**
 * 服务请求控制器
 * */
@Controller
@RequestMapping("/service")
public class ServiceRequestController {

	private final Log logger = LogFactory
			.getLog(ServiceRequestController.class);

	@Autowired
	private RequestService requestService;

	/**
	 * 请求客房视图
	 * 
	 * @param type
	 *            请求类型 <br />
	 *            类型可任意组合 1=服务请求 2=SOS 4=出租状态 8=HVAC0 16=通讯故障 32=能耗 256=HVAC1
	 *            512=HVAC2
	 * */
	@RequestMapping(value = "/roomviews", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> getRoomviews(
			@RequestParam(value = "type", required = true) Integer type) {
		List<Map<String, String>> list = null;
		Map<String,String> errMap = null;
		StringBuilder errors = new StringBuilder();
		try {
			list = requestService.getRoomviews(type);
		} catch (MalformedURLException e) {
			logger.error(e);
			e.printStackTrace();

			errors.append(e.getLocalizedMessage());
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			errors.append(e.getLocalizedMessage());
		}
		
		//添加异常信息
		if(errors.length()>0) {
			errMap = new HashMap<String,String>();
			errMap.put("error", errors.toString());
			list = new ArrayList<Map<String, String>>();
			list.add(errMap);
		}

		return list;
	}
	
	/**
	 * 设置值
	 * @param roomNo 当前房间号
	 * @param p 当前温控器编号
	 * @param value 设置温度值
	 * */
	@RequestMapping(value = "/setvalue", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> processSetVal(@RequestParam(value = "roomNo", required = true) String roomNo,
			@RequestParam(value = "p", required = true,defaultValue="0") String p,
			@RequestParam(value = "value", required = true) String value) {
		List<Map<String, String>> list = null;
		Map<String,String> errMap = null;
		StringBuilder errors = new StringBuilder();
		
		try {
			list = requestService.setValue(roomNo, p, value);
		} catch (MalformedURLException e) {
			logger.error(e);
			e.printStackTrace();

			errors.append(e.getLocalizedMessage());
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			errors.append(e.getLocalizedMessage());
		}
		
		//添加异常信息
		if(errors.length()>0) {
			errMap = new HashMap<String,String>();
			errMap.put("error", errors.toString());
			list = new ArrayList<Map<String, String>>();
			list.add(errMap);
		}
		
		return list;
	}
	
	
	/**
	 * CheckIn客人信息
	 * @param roomNo 当前房间号
	 * @param guestName 客人姓名
	 * @param language 语言
	 * @param tempSet 设置温度值
	 * */
	@RequestMapping(value = "/checkin", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> processCheckin(
			@RequestParam(value = "roomNo", required = true) String roomNo,
			@RequestParam(value = "guestName", required = false) String guestName,
			@RequestParam(value = "language", required = false,defaultValue="1") String language,
			@RequestParam(value = "tempSet", required = true) String tempSet) {
		List<Map<String, String>> list = null;
		Map<String,String> errMap = null;
		StringBuilder errors = new StringBuilder();
		
		try {
			list = requestService.checkIn(roomNo, guestName, language, tempSet);
		} catch (MalformedURLException e) {
			logger.error(e);
			e.printStackTrace();

			errors.append(e.getLocalizedMessage());
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			errors.append(e.getLocalizedMessage());
		}
		
		//添加异常信息
		if(errors.length()>0) {
			errMap = new HashMap<String,String>();
			errMap.put("error", errors.toString());
			list = new ArrayList<Map<String, String>>();
			list.add(errMap);
		}
		
		
		return list;
	}
	
	

}
