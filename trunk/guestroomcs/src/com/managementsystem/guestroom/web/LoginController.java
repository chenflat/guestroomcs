package com.managementsystem.guestroom.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController implements IController {

	private final Log logger = LogFactory.getLog(LoginController.class);

	public static final String VIEW_NAME = "login";

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.debug("Requesting doGet of " + LoginController.class);
		ModelAndView mav = new ModelAndView();

		mav.setViewName(VIEW_NAME);
		return mav;
	}
	
	
	@RequestMapping(value="/loginfailed",method=RequestMethod.GET)
	public ModelAndView doGetLoginfailed(ModelMap model) {
		logger.debug("Requesting doGet of " + LoginController.class);
		ModelAndView mav = new ModelAndView();

		mav.setViewName(VIEW_NAME);
		return mav;
	}
	
	

}
