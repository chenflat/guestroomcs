package com.managementsystem.guestroom.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Floor;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.FloorService;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.web.AbstractController;

/**
 * 请求明细处理
 * 
 * @author PING.CHEN
 * */
@Controller
@RequestMapping("/service/requests/details")
public class RequestDetailsController extends AbstractController {

	private final Log logger = LogFactory
			.getLog(RequestDetailsController.class);

	public static final String VIEW_NAME = "service/requests/details";

	private static final int maxNum = 12;
	
	@Autowired
	private FloorService floorService;

	@Autowired
	private BuildService buildService;

	@Autowired
	private HotelService hotelService;

	/**
	 * 请求指定ID的楼层对象
	 * */
	@RequestMapping(value = "/{floorId}", method = RequestMethod.GET)
	public ModelAndView doGet(@PathVariable("floorId") String floorId) {
		logger.info("Requesting doGet of " + RequestDetailsController.class);
		ModelAndView mav = new ModelAndView();

		Floor floor = null;
		Map<String, List<Floor>> floorSections = null;
		try {
			floor = floorService.get(floorId);
			floorSections = getFloorSections();

		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("floor", floor);
		mav.addObject("floorSections", floorSections);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@Override
	protected String getModelViewName() {

		return null;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {

		return null;
	}

	/**
	 * 获取楼层段落
	 * */
	private Map<String, List<Floor>> getFloorSections() {
		Map<String, List<Floor>> result = new HashMap<String, List<Floor>>();
		
		List<Floor> floors = new LinkedList<Floor>();
		Hotel hotel = hotelService.getDefaultHotel();
		Set<Build> builds = buildService.getBuildsByHotelId(hotel.getHotelId());
		for (Build build : builds) {
			floors.addAll(floorService.getFloorByBuild(build.getBuildId()));
		}

		int size = floors.size();
		int sections = size / maxNum;

		int count = size > (maxNum * sections) ? sections + 1 : sections;

		String text = null;
		int index = 0;
		int last = maxNum - 1;
		for (int i = 0; i < count; i++) {
			index = i > 0 ? i * maxNum : i;
			if (last <= size && i > 0) {
				last = (i + 1) * last + 1;
			}
			if (last >= size) {
				last = size - 1;
			}
			text = String.format("F%s-F%s", floors.get(index).getFloorNo(),floors.get(last).getFloorNo());
			System.out.println(text);

			List<Floor> list = new ArrayList<Floor>();
			for (int j = index; j < last; j++) {
				list.add(floors.get(j));
			}
			result.put(text, list);
		}
		return result;
	}

}
