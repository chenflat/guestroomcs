package com.managementsystem.guestroom.web.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.Breadcrumb;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * Dictionary Manage Author:CHENPING Date: 2012-10-19
 * */
@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(getClass());

	public static final String VIEW_NAME = "system/dictionary";

	/**
	 * Dictionary LIST
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + DictionaryController.class);
		logger.debug("dictionary settings");
		ModelAndView mav = new ModelAndView();

		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	protected List<Breadcrumb> getBreadcrumbs() {
		List<Breadcrumb> result = new ArrayList<Breadcrumb>();
		result.add(new Breadcrumb("Home", "Home page", ""));
		return result;
	}

}
