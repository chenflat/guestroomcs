package com.managementsystem.guestroom.web.account;

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

@Controller
@RequestMapping("/account/usability")
public class UsabilityController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(UsabilityController.class);

	public static final String VIEW_NAME = "account/usability";

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + ShiftworkController.class);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		return null;
	}

}
