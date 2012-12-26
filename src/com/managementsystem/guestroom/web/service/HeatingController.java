package com.managementsystem.guestroom.web.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.guestroom.web.AbstractController;


/**
 * 浴室地板加热
 * 
 * @author PING.CHEN
 * 
 * */
@Controller
@RequestMapping("/service/heating")
public class HeatingController extends AbstractController {

private final Log logger = LogFactory.getLog(HeatingController.class);

	public static final String VIEW_NAME = "service/heating";
	
	@Autowired
	public BuildService buildService ;
	
	@Autowired
	public FloorService floorService;
	
	@Autowired
	public RoomService roomService;
	
	/**
	 * 建筑楼层
	 * */
	@ModelAttribute("floors")
	public Set<Floor> getFloorsByDefHotel() {
		Set<Build> builds = buildService.getBuilds();
		Set<Floor> floors = new LinkedHashSet<Floor>();
		for(Build build : builds) {
			floors.addAll(floorService.getFloorByBuild(build.getBuildId()));
		}
		for(Floor floor : floors) {
			Set<Room> rooms = roomService.getRoomsByFloorId(floor.getFloorId());
			floor.setRooms(rooms);
		}	
		return floors;
	}
	
	
	/**
	 * 请求浴室地板加热视图
	 * */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView doGet() {
		logger.info("Requesting doGet of "+ HeatingController.class);
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
