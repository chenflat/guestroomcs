package com.managementsystem.guestroom.web.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.guestroom.service.biz.RoomService;
import com.managementsystem.guestroom.web.AbstractController;

public abstract class AbstractRoomController extends AbstractController {
	
	protected abstract String getModelViewName();

	protected abstract List<Breadcrumb> getBreadcrumbs();
	
	

	@Autowired
	private BuildService buildService ;
	
	@Autowired
	private FloorService floorService;
	
	@Autowired
	private RoomService roomService;
	
	/**
	 * 获取默认酒店建筑的所有楼层数据
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
}
