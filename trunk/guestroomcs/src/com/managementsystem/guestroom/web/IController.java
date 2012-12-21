package com.managementsystem.guestroom.web;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public interface IController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model);
	
	
}
