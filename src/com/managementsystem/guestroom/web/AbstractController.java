package com.managementsystem.guestroom.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.UserService;

public abstract class AbstractController {

	private final Log logger = LogFactory.getLog(AbstractController.class);

	protected abstract String getModelViewName();

	protected abstract List<Breadcrumb> getBreadcrumbs();

	@Autowired
	private UserService userService;

	protected User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = auth.getName();
		if (username != null)
			return userService.getUserByName(username);
		return null;

	}

}
