package com.managementsystem.guestroom.web.system;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.service.platform.PortalService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

@Controller
@RequestMapping("/system/settings")
public class SettingController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(getClass());

	public static final String VIEW_NAME = "system/settings";

	@Autowired
	private PortalService portalService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + SettingController.class);
		ModelAndView mav = new ModelAndView();
		Portal portalInfo = portalService.getDefaultPortalinfo();
		if (portalInfo == null)
			portalInfo = new Portal();
		mav.addObject("portal", portalInfo);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void processSubmit(@ModelAttribute("portal") Portal portalInfo,
			BindingResult result, SessionStatus status) {

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
