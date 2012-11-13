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
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * 客房管理
 * */
@Controller
@RequestMapping("hotel/roommanage")
public class RoommanageController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(BuildmanageController.class);

	public static final String VIEW_NAME = "hotel/roommanage";

	@Autowired
	private RoomService roomService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private BuildService buildService;

	@Autowired
	private FloorService floorService;

	/**
	 * 客房管理
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + RoommanageController.class);
		ModelAndView mav = new ModelAndView();
		Set<Hotel> hotels = hotelService.getHotels();
		long totalRooms = roomService.getCountRoomsByDefHotel();

		Set<Build> builds = null;
		Set<Floor> floors = null;
		Set<Room> rooms = null;
		if (hotels.size() > 0) {
			for (Hotel hotel : hotels) {
				builds = buildService.getBuildsByHotelId(hotel.getHotelId());
				hotel.setBuilds(builds);
				for (Build build : builds) {
					floors = floorService.getFloorByBuild(build.getBuildId());
					build.setFloors(floors);
					for (Floor floor : floors) {
						rooms = roomService.getRoomsByFloorId(floor
								.getFloorId());
						floor.setRooms(rooms);
					}
				}
			}
		}

		mav.addObject("hotels", hotels);
		mav.addObject("totalRooms", totalRooms);

		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		// TODO Auto-generated method stub
		return null;
	}

}
