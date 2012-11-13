package com.managementsystem.guestroom.web.hotel;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Roomtype;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.RoomtypeService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * 客房类型操作
 * */
@Controller
public class EditRoomtypeController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(EditRoomtypeController.class);

	private final String VIEW_NAME = "hotel/roomtype/edit";
	
	@Autowired
	private RoomtypeService roomtypeService;
	

	/**
	 * 新增
	 * */
	@RequestMapping(value = "/hotel/roomtype/edit", method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + EditRoomtypeController.class);
		ModelAndView mav = new ModelAndView();
		Roomtype roomtype = new Roomtype();
		mav.addObject("roomtype", roomtype);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 编辑
	 * */
	@RequestMapping(value = "/hotel/roomtype/edit/{roomtypeId}", method = RequestMethod.GET)
	public ModelAndView doGetEdit(
			@PathVariable("roomtypeId") String roomtypeId, ModelMap model) {
		logger.info("Requesting doGet of " + EditRoomtypeController.class);
		ModelAndView mav = new ModelAndView();

		Roomtype roomtype = null;
		String message = null;
		if(!StringUtils.hasLength(roomtypeId)) {
			message = "error.object.null";
		} else {
			roomtype = roomtypeService.get(roomtypeId);
			if(roomtype==null) {
				message = "error.object.null";
			}
		}
		mav.addObject("roomtype", roomtype);
		mav.addObject("message", message);
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
