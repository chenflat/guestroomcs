package com.managementsystem.guestroom.web.system;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统管理首页控制器
 * */
@Controller
@RequestMapping("/system/navigation")
public class NavigationController {

	private final Log logger = LogFactory.getLog(NavigationController.class);

	private final String VIEW_NAME = "system/navigation";

	/**
	 * 设置系统首页
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet() {
		logger.info("requesting doGet of " + NavigationController.class);
		ModelAndView mav = new ModelAndView();

		mav.setViewName(VIEW_NAME);
		return mav;
	}

}
