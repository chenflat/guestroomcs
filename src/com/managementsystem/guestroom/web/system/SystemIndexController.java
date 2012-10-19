package com.managementsystem.guestroom.web.system;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.web.BaseController;

@Controller
@RequestMapping("/system/*")
public class SystemIndexController extends BaseController {

	private final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView setupSystemindex(Model model) {
		logger.debug("setupindex");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("system/index");
		return mav;
	}

}
