package com.managementsystem.guestroom.web.system;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.guestroom.domain.hibernate.Portal;
import com.managementsystem.guestroom.service.platform.ListinfoService;
import com.managementsystem.guestroom.service.platform.PortalService;
import com.managementsystem.guestroom.validation.PortalValidator;
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

	@Autowired
	private ListinfoService listinfoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + SettingController.class);
		ModelAndView mav = new ModelAndView();
		Portal portalInfo = portalService.getDefaultPortalinfo();
		if (portalInfo == null)
			portalInfo = new Portal();
		mav.addObject("portal", portalInfo);

		Set<Listinfo> listitems = listinfoService.getListEntryItems("Currency");
		mav.addObject("listitems", listitems);

		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("portal") Portal portal,
			BindingResult result, SessionStatus status) {

		new PortalValidator().validator(portal, result);
		if (result.hasErrors()) {
			logger.error(result);
		} else {
			try {
				if (StringUtils.hasLength(portal.getPortalId())) {
					portalService.update(portal);
				} else {
					portalService.save(portal);
				}
				status.setComplete();
			} catch (Exception e) {

			}

		}
		return "redirect:/system/settings";
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
