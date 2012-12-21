package com.managementsystem.guestroom.web;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;

/**
 * 房间抽象类
 * */
public abstract class AbstractRoomController {

	private final Log logger = LogFactory.getLog(AbstractRoomController.class);
	
	@Autowired
	public FloorService floorService;
	
	@Autowired
	public BuildService buildService ;
	
	@ModelAttribute("floors")
	public Set<Floor> getFloorsByDefHotel() {
		logger.info("Get the default hotel building's floors and rooms");
		Set<Build> builds = buildService.getBuilds();
		Set<Floor> floors = new LinkedHashSet<Floor>();
		for(Build build : builds) {
			floors.addAll(floorService.getFloorByBuild(build.getBuildId()));
		}
		return floors;
	}
	
	
	
}
