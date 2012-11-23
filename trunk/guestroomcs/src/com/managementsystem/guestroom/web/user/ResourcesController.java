package com.managementsystem.guestroom.web.user;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.service.platform.ResourceService;
import com.managementsystem.ui.easyui.Tree;

/**
 * 权限资源操作控制器
 * */
@Controller
public class ResourcesController {

	private final Log logger = LogFactory.getLog(ResourcesController.class);

	private final String VIEW_NAME = "user/resources";

	@Autowired
	private ResourceService resourceService;

	/**
	 * 显示资源列表
	 * */
	@RequestMapping(value = "/user/resources", method = RequestMethod.GET)
	public ModelAndView doGet() {
		logger.info("Requesting doGet of " + ResourcesController.class);
		ModelAndView mav = new ModelAndView();
		List<Tree> resourcetree = resourceService.getUrlTypeOfResourcesTree();
		mav.addObject("resourcetree", resourcetree);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

}
