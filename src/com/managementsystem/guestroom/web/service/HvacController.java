package com.managementsystem.guestroom.web.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.Breadcrumb;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;


@Controller
public class HvacController extends AbstractController implements IController {
	
	private final Log logger = LogFactory.getLog(HvacController.class);
	
	public static final String VIEW_NAME = "service/hvac";
	
	@RequestMapping("service/hvac")
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of "+ HvacController.class);
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
