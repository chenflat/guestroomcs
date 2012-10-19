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
 * Dictionary Manage
 * Author:CHENPING
 * Date: 2012-10-19
 * */
@Controller
@RequestMapping("/system/*")
public class DictionaryController extends BaseController {

	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * Dictionary LIST
	 * */
	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public ModelAndView setupDictionary(Model model) {
		logger.debug("dictionary settings");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("system/dictionary");
		return mav;
	}
	
}
