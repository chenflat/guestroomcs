package com.managementsystem.guestroom.web.system;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;




/**
 * FAQ Manage
 * Author:CHENPING
 * Date: 2012-10-19
 * */
@Controller
@RequestMapping("/system/faqmanage")
public class FaqController extends AbstractController implements IController {
	
	private final Log logger = LogFactory.getLog(FaqController.class);

	public static final String VIEW_NAME = "system/faqmanage";
	
	
	/**
	 * FAQ LIST
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of "+ FaqController.class);
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