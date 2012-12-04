package com.managementsystem.guestroom.web.service;

import java.io.IOException;
import java.net.MalformedURLException;
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
		try {
			list = requestService.getRoomviews(type);
		} catch (MalformedURLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return list;
	}

}
