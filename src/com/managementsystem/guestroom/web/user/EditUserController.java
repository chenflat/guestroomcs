package com.managementsystem.guestroom.web.user;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.RoleService;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

@Controller
public class EditUserController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(EditUserController.class);

	private final String VIEW_NAME = "user/edit";

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

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + EditUserController.class);
		ModelAndView mav = new ModelAndView();

		Set<User> users = userService.getUsers();
		mav.addObject("users", users);

		User user = new User();
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
