package com.managementsystem.guestroom.web.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.managementsystem.guestroom.domain.platform.Roomcounter;
import com.managementsystem.guestroom.service.biz.RequestService;

/**
 * 服务请求统计
 * 
 * @author ping.chen
 * */
@Controller
@RequestMapping("/service/statistics")
public class RequestStatisticsController {

	private final Log logger = LogFactory
			.getLog(RequestStatisticsController.class);

	@Autowired
	private RequestService requestService;

	/**
	 * 获取服务请求统计
	 * */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Roomcounter getRequestStatistics() {
		Roomcounter counter = null;
		try {
			counter = requestService.getRoomcounter();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return counter;
	}

}
