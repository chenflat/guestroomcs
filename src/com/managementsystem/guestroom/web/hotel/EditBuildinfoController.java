package com.managementsystem.guestroom.web.hotel;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Build;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.platform.Message;
import com.managementsystem.guestroom.service.biz.BuildService;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.validation.BuildValidator;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.ui.easyui.Resultmsg;

/**
 * 编辑建筑信息
 * */
@Controller
public class EditBuildinfoController extends AbstractController {

	private final Log logger = LogFactory.getLog(EditBuildinfoController.class);

	private final String VIEW_NAME = "hotel/build/edit";

	@Autowired
	private BuildService buildService;

	@Autowired
	private HotelService hotelService;

	/**
	 * 新增建筑信息
	 * */
	@RequestMapping(value = "/hotel/build/add", method = RequestMethod.GET)
	public ModelAndView setup(ModelMap model) {
		logger.info("Requesting doGet of " + EditBuildinfoController.class);
		ModelAndView mav = new ModelAndView();
		String message = "";
		Hotel hotel = hotelService.getDefaultHotel();
		Build build = null;
		if (hotel != null) {
			build = new Build();
			build.setHotel(hotel);
		} else {
			message = "error.object.null";
		}
		mav.addObject("hotel", message);
		mav.addObject("build", build);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 编辑建筑信息
	 * */
	@RequestMapping(value = "/hotel/build/edit/{buildId}", method = RequestMethod.GET)
	public ModelAndView doGet(@PathVariable("buildId") String buildId,
			ModelMap model) {
		logger.info("Requesting doGet of " + EditBuildinfoController.class);

		ModelAndView mav = new ModelAndView();
		Build build = null;
		String message = "";
		if (!StringUtils.hasLength(buildId)) {
			message = "buildId is null or empty";
		} else {
			build = buildService.get(buildId);
			if (build == null) {
				message = "Object is null,buildId=" + buildId;
			}
		}
		mav.addObject("message", message);
		mav.addObject("build", build);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 保存建筑信息
	 * */
	@RequestMapping(value = "/hotel/build/save", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("build") Build build,
			Model model, BindingResult result, SessionStatus status) {
		new BuildValidator().validate(build, result);
		if (result.hasErrors()) {
			logger.error(result);
			model.addAttribute("message",
					new Message(Alert.ERROR, result.toString()));
			if (StringUtils.hasLength(build.getBuildId())) {
				return "redirect:/hotel/build/edit/" + build.getBuildId();
			} else {
				return "redirect:/hotel/build/add";
			}
		} else {
			if (StringUtils.hasLength(build.getBuildId())) {
				buildService.update(build);
			} else {
				buildService.save(build);
				status.setComplete();
				model.addAttribute("message", new Message(Alert.SUCCESS,
						"success"));
			}
			return "redirect:/hotel/build/edit/" + build.getBuildId();
		}
	}

	/**
	 * 删除酒店建筑
	 * 
	 * @param buildId
	 *            建筑ID
	 * @return JSON结果
	 * */
	@RequestMapping(value = "/hotel/build/delete", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processDelete(
			@RequestParam(value = "buildId", required = true) String buildId) {
		Resultmsg msg = new Resultmsg();
		msg.setSuccess("true");
		try {
			logger.info("Requesting processDelete of "
					+ EditBuildinfoController.class);
			if (StringUtils.hasLength(buildId)) {
				buildService.delete(buildId);
			} else {
				msg.setMsg("buildId is null");
				msg.setSuccess("false");
			}

		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setSuccess("false");
		}
		return msg;
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
