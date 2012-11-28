package com.managementsystem.guestroom.web.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.guestroom.domain.hibernate.RoomgroupForm;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.guestroom.service.biz.RoomgroupService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * 客房管理
 * */
@Controller
@RequestMapping("/hotel/room")
public class RoommanageController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(RoommanageController.class);

	public static final String VIEW_NAME = "hotel/room";

	@Autowired
	private RoomService roomService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private BuildService buildService;

	@Autowired
	private FloorService floorService;

	@Autowired
	private RoomgroupService roomgroupService;

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

		List<Roomgroup> roomgrouplist = new ArrayList<Roomgroup>(
				roomgroupService.getRoomgroups());
		
		RoomgroupForm roomgroupForm = new RoomgroupForm();
		roomgroupForm.setRoomgroups(roomgrouplist);

		mav.addObject("hotels", hotels);
		mav.addObject("totalRooms", totalRooms);

		mav.addObject("roomgroupForm", roomgroupForm);

		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 删除选定的房间
	 * */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String porcessDelete(WebRequest request) {
		if (request.getParameter("roomNos") != null) {
			String roomNos = request.getParameter("roomNos");
			if (StringUtils.hasLength(roomNos)) {
				if (roomNos.indexOf(",") > -1) {
					String[] arrRoomNos = roomNos.split(",");
					for (String roomno : arrRoomNos) {
						if (StringUtils.hasLength(roomno)) {
							roomService.delete(roomno);
						}
					}
				} else {
					roomService.delete(roomNos);
				}
			}

			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping(value="/query",method = RequestMethod.POST)
	public String processQuery(@RequestParam("query")String query) {
		logger.info("requesting query post of " + RoommanageController.class);
		
		return "redirect:/hotel/room";
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
