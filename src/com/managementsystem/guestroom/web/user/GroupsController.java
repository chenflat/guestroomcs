package com.managementsystem.guestroom.web.user;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.service.platform.RoleService;

/**
 * 角色控制器
 * */
@Controller
public class GroupsController {

	private final Log logger = LogFactory.getLog(GroupsController.class);

	private final String VIEW_NAME = "user/groups";

	@Autowired
	private RoleService roleService;

	/**
	 * 显示角色列表
	 * */
	@RequestMapping(value = "/user/groups", method = RequestMethod.GET)
	public ModelAndView doGet() {
		logger.info("Requesting doGet of " + GroupsController.class);
		ModelAndView mav = new ModelAndView();
		Set<Role> roles = roleService.getEnabledRoles();
		mav.addObject("roles", roles);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

}
