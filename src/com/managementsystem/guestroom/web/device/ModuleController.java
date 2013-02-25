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



/**
 * 设备模块信息
 * 
 * @author PING.CHEN 2013-02-25
 * 
 * */
@Controller
public class ModuleController extends AbstractController {

	private final Log logger = LogFactory.getLog(ModuleController.class);
	
	public static final String VIEW_NAME = "device/module";
		
	/**
	 * 显示设备模块列表
	 * */
	@RequestMapping(value = "/device/module", method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("@Requesting doGet of " + ModuleController.class);
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
