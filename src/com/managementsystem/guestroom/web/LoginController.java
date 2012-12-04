package com.managementsystem.guestroom.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

	private final Log logger = LogFactory.getLog(LoginController.class);

	public static final String VIEW_NAME = "login";

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView processLoginfailed(
			@RequestParam(required = false, value = "error") String error,
			ModelMap model) {
		logger.debug("Requesting doGet of " + LoginController.class);
		ModelAndView mav = new ModelAndView();
		String errmsg = null;
		if (StringUtils.hasLength(error)) {
			errmsg = error;
		}
		mav.addObject("error", errmsg);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

}
