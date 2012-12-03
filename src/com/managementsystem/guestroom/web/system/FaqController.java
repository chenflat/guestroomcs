package com.managementsystem.guestroom.web.system;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Faqcategory;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.FaqService;
import com.managementsystem.guestroom.service.platform.FaqcategoryService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.util.dao.Page;




/**
 * FAQ Manage
 * Author:CHENPING
 * Date: 2012-10-19
 * */
@Controller
@RequestMapping("/system/faqmanage")
public class FaqController extends AbstractController implements IController {
	
	private final Log logger = LogFactory.getLog(FaqController.class);

	public static final String VIEW_NAME = "system/faqmanage";
	
	@Autowired
	private FaqcategoryService faqcategoryService;
	
	@Autowired
	private FaqService faqService;
	
	
	@ModelAttribute("faqcategories")
	public List<Faqcategory> getFaqcategories() {
		return faqcategoryService.getFaqcategories();
	}
	
	/**
	 * FAQ LIST
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of "+ FaqController.class);
		ModelAndView mav = new ModelAndView();

		mav.setViewName(VIEW_NAME);
		return mav;
	}
	
	/**
	 * FAQ LIST
	 * */
	@RequestMapping(value="/{catId}",method = RequestMethod.GET)
	public ModelAndView getFaqinfosByCatid(@PathVariable("catId") String catId) {
		logger.info("Requesting doGet of "+ FaqController.class);
		ModelAndView mav = new ModelAndView();
		
		Faqcategory faqcategory = faqcategoryService.get(catId);
		Page faqPage = faqService.getFaqinfosByCatid(0, 10000, catId);
		
		mav.addObject("faqcategory", faqcategory);
		mav.addObject("faqs", faqPage.getResult());
		mav.setViewName(VIEW_NAME);
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/query",method = RequestMethod.POST)
	public String processQuery(@RequestParam("query")String query) {
		logger.info("requesting query post of " + FaqController.class);
		
		return "redirect:/system/faqmanage";
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
