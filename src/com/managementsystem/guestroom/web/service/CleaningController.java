package com.managementsystem.guestroom.web.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.web.IController;

/**
 * Cleaning房间
 * 
 * @author PING.CHEN
 * 
 * */
@Controller
@RequestMapping("/service/cleaning")
public class CleaningController extends AbstractRoomController implements
		IController {

	private final Log logger = LogFactory.getLog(CleaningController.class);
	
	public static final String VIEW_NAME = "service/cleaning";

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView doGet(ModelMap model) {
		
		logger.info("requesting doGet of "+ CleaningController.class);
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
