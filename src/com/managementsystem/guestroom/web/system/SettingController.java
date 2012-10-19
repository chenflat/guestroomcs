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
public class SettingController extends BaseController {

	private final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "settings", method = RequestMethod.GET)
	public ModelAndView setupSystemindex(Model model) {
		logger.debug("system settings");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("system/settings");
		return mav;
	}

}
