package com.managementsystem.guestroom.web.hotel;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.common.Constants;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.hibernate.Roomtype;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.platform.Message;
import com.managementsystem.guestroom.service.biz.RoomtypeService;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.validation.RoomtypeValidator;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.util.io.FileSystemObject;

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

	@Autowired
	private HotelService hotelService;
	
	@ModelAttribute("hotels")
	public Set<Hotel> getHotels() {
		return hotelService.getHotels();
	}
	
	
	
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
		if (!StringUtils.hasLength(roomtypeId)) {
			message = "error.object.null";
		} else {
			roomtype = roomtypeService.get(roomtypeId);
			if (roomtype == null) {
				message = "error.object.null";
			}
		}
		mav.addObject("roomtype", roomtype);
		mav.addObject("message", message);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 保存
	 * */
	@RequestMapping(value = "/hotel/roomtype/edit/*", method = RequestMethod.POST)
	public ModelAndView processSubmit(
			@ModelAttribute("roomtype") Roomtype roomtype,
			@RequestParam MultipartFile file, BindingResult result,
			SessionStatus status, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Message message = null;
		new RoomtypeValidator().validator(roomtype, result);
		if (result.hasErrors()) {
			message = new Message(Alert.ERROR, result.toString());
		} else {
			String photoPath = "";
			if (file.getSize() > 0) {
				String realPath = request.getSession().getServletContext()
						.getRealPath("/");
				String filePath = Constants.PATH_UPLOADFILE_ROOMTYPE;
				try {
					FileSystemObject.SaveFileFromInputStream(
							file.getInputStream(), realPath + filePath,
							file.getOriginalFilename());
					logger.info("File '" + file.getOriginalFilename()
							+ "' uploaded successfully");
					photoPath = filePath + file.getOriginalFilename();
					roomtype.setRoomtypePhoto(photoPath);
				} catch (IOException e) {
					e.printStackTrace();
					message = new Message(Alert.ERROR, e.toString());
				}
			}
			try {
				if (StringUtils.hasLength(roomtype.getRoomtypeId())) {
					roomtypeService.update(roomtype);
				} else {
					roomtypeService.save(roomtype);
				}
				message = new Message(Alert.SUCCESS, "successful!");
			} catch (Exception e) {
				message = new Message(Alert.ERROR, e.toString());
			}
		}
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
