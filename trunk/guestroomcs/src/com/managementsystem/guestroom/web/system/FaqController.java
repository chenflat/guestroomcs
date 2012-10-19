package com.managementsystem.guestroom.web.system;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.web.BaseController;


/**
 * FAQ Manage
 * Author:CHENPING
 * Date: 2012-10-19
 * */
@Controller
@RequestMapping("/system/*")
public class FaqController extends BaseController {
	
	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * FAQ LIST
	 * */
	@RequestMapping(value = "faqmanage", method = RequestMethod.GET)
	public ModelAndView setupFaqmanage(Model model) {
		logger.debug("system settings");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("system/faqmanage");
		return mav;
	}
}
