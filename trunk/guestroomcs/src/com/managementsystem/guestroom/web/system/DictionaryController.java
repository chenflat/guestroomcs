package com.managementsystem.guestroom.web.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.ListinfoService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * Dictionary Manage Author:CHENPING Date: 2012-10-19
 * */
@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(getClass());

	public static final String VIEW_NAME = "system/dictionary";

	@Autowired
	private ListinfoService listinfoService;

	/**
	 * 列表字典
	 * */
	@ModelAttribute("dictionaries")
	public Set<Listinfo> getCategories() {
		return listinfoService.getListinfoDictionary();
	}

	/**
	 * 字典表
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + DictionaryController.class);
		logger.debug("dictionary settings");
		ModelAndView mav = new ModelAndView();

		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public List<Listinfo> getListinfos(@RequestParam("listname") String listname) {
		logger.info("Requesting getListinfos of " + DictionaryController.class);
		List<Listinfo> list = null;
		try {
			if(StringUtils.hasLength(listname)) {
				list = new ArrayList<Listinfo>(listinfoService.getListEntryItems(listname));
			}
		} catch (Exception e) {
			
		}
		return list;
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String processQuery(@RequestParam("query") String query) {
		logger.info("requesting query post of " + DictionaryController.class);

		return "redirect:/system/dictionary";
	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	protected List<Breadcrumb> getBreadcrumbs() {
		List<Breadcrumb> result = new ArrayList<Breadcrumb>();
		result.add(new Breadcrumb("Home", "Home page", ""));
		return result;
	}

}
