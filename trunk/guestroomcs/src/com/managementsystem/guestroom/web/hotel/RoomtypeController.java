package com.managementsystem.guestroom.web.hotel;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Roomtype;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.RoomtypeService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

@Controller
@RequestMapping("/hotel/roomtype")
public class RoomtypeController extends AbstractController implements
		IController {
	private final Log logger = LogFactory.getLog(RoomtypeController.class);

	private final String VIEW_NAME = "hotel/roomtype";

	@Autowired
	private RoomtypeService roomtypeService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of" + RoomtypeController.class);
		ModelAndView mav = new ModelAndView();
		Set<Roomtype> roomtypes = roomtypeService.getRoomtypes();
		mav.addObject("roomtypes", roomtypes);
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
