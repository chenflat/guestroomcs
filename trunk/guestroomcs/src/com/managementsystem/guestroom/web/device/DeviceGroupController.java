package com.managementsystem.guestroom.web.device;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.web.AbstractController;

@Controller
public class DeviceGroupController  extends AbstractController {

	private final Log logger = LogFactory.getLog(DeviceGroupController.class);
	
	private static final String VIEW_NAME = "device/group";
	
	/**
	 * 显示设备组模板列表
	 * */
	@RequestMapping(value = "/device/group", method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("@Requesting doGet of " + DeviceGroupController.class);
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
