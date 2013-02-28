package com.managementsystem.guestroom.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;

@Controller
@RequestMapping("/index")
public class IndexController extends AbstractController {

	private final Log logger = LogFactory.getLog(IndexController.class);

	public static final String VIEW_NAME = "index";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model) {
		logger.debug("setupindex");

		return "redirect:/service/requests";
	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}
	
	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		List<Breadcrumb> result = new ArrayList<Breadcrumb>();
		result.add(new Breadcrumb("Home", "Home page", ""));
		return result;
	}
}
