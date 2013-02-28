package com.managementsystem.guestroom.web.device;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * 初始设备数据
 * */
@Controller
@RequestMapping("/device/initialize")
public class InitializeController extends AbstractController implements
		IController {

	private final static String VIEW_NAME = "device/initialize";

	private final Log logger = LogFactory.getLog(InitializeController.class);

	@Autowired
	private RoomService roomService;
	
	private boolean isInitRoom = false,isInitModule = false,isTestConfig = false;
	private Map<String,String> configResult = null,message = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("@Requesting doGet of " + InitializeController.class);
		ModelAndView mav = new ModelAndView();

		long countRoom = roomService.getCountRoomsByDefHotel();
		isInitRoom = countRoom > 0;
		mav.addObject("isInitRoom", isInitRoom);
		
		mav.addObject("isInitModule", isInitModule);
		mav.addObject("isTestConfig", isTestConfig);
		mav.addObject("message", message);
		mav.addObject("configResult", configResult);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		return null;
	}

}
