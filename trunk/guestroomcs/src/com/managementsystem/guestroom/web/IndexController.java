package com.managementsystem.guestroom.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*")
public class IndexController extends BaseController {

	private final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView setupIndex(Model model) {
		logger.debug("setupindex");
		ModelAndView mav = new ModelAndView();

		return mav;
	}
}
