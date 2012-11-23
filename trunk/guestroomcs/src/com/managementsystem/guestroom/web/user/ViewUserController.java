package com.managementsystem.guestroom.web.user;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.RoleService;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.guestroom.web.AbstractController;

@Controller
public class ViewUserController extends AbstractController {

	private final Log logger = LogFactory.getLog(ViewUserController.class);

	private final String VIEW_NAME = "user/users/view";

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	/**
	 * 活动角色
	 * */
	@ModelAttribute("roles")
	public Set<Role> getEnabledRoles() {
		return roleService.getEnabledRoles();
	}
	
	/**
	 * 所有用户
	 * */
	@ModelAttribute("users")
	public Set<User> getUsers() {
		return userService.getUsers();
	}
	
	
	/**
	 * 查看用户信息
	 * */
	@RequestMapping(value = "/user/users/view/{userId}", method = RequestMethod.GET)
	public ModelAndView doGet(@PathVariable("userId")String userId) {
		logger.info("Requesting doGetEdit of " + EditUserController.class);
		ModelAndView mav = new ModelAndView();
		User user = userService.get(userId);
		mav.addObject("user", user);
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
