package com.managementsystem.guestroom.web.analyse;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.Breadcrumb;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;


/**
 * 数据分析之数据摘要
 * 
 * @author CHENPING
 * 			2012-10-29
 * */
@Controller
public class SummaryController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(SummaryController.class);
	
	public static final String VIEW_NAME = "analyse/summary";
	
	@RequestMapping(value="analyse/summary",method=RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of "+ SummaryController.class);
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
