package com.managementsystem.guestroom.web.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * HVAC暖通空调操作类
 * 
 * @author PING.CHEN
 * */
@Controller
public class HvacController extends AbstractRoomController implements IController {
	
	private final Log logger = LogFactory.getLog(HvacController.class);
	
	private static final String VIEW_NAME = "service/hvac";
	
	/**
	 * 请求HVAC视图
	 * */
	@RequestMapping("service/hvac")
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of "+ HvacController.class);
		ModelAndView mav = new ModelAndView();
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
