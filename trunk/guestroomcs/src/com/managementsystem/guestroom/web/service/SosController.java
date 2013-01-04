package com.managementsystem.guestroom.web.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * SOS房间
 * 
 * @author PING.CHEN
 * 
 * */
@Controller
@RequestMapping("/service/sos")
public class SosController extends AbstractRoomController implements IController {

	public static final String VIEW_NAME = "service/sos";
	
	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView doGet(ModelMap model) {
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
