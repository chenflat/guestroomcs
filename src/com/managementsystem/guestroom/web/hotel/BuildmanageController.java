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

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

@Controller
@RequestMapping("hotel/build")
public class BuildmanageController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(BuildmanageController.class);

	public static final String VIEW_NAME = "hotel/build";

	@Autowired
	private BuildService buildService;

	@Autowired
	private HotelService hotelService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + BuildmanageController.class);
		ModelAndView mav = new ModelAndView();
		Set<Build> builds = null;
		Hotel hotel = hotelService.getDefaultHotel();
		String message = null;
		if (hotel != null) {
			builds = buildService.getBuildsByHotelId(hotel.getHotelId());
		} else {
			message = "error.object.null";
		}
		mav.addObject("message", message);
		mav.addObject("builds", builds);
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
