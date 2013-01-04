package com.managementsystem.guestroom.web.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.guestroom.service.biz.RoomgroupService;
import com.managementsystem.guestroom.web.IController;

@Controller
@RequestMapping("/service/requests")
public class RequestsController  extends AbstractRoomController implements IController {

	private final Log logger = LogFactory.getLog(RequestsController.class);
	
	public static final String VIEW_NAME = "service/requests";
	
	@Autowired
	public RoomService roomService;
	
	@Autowired
	public BuildService buildService ;
	
	@Autowired
	public RoomgroupService roomgroupService;

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of "+ RequestsController.class);
		ModelAndView mav = new ModelAndView();
		Set<Roomgroup> roomgroups = roomgroupService.getRoomgroups();
		mav.addObject("roomgroups", roomgroups);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	
	@RequestMapping(value="/rooms",method = RequestMethod.POST)
	@ResponseBody
	public Set<Room> getRooms() {
		 Set<Room> rooms = roomService.getRoomsByDefHotel();
		 return rooms;
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
