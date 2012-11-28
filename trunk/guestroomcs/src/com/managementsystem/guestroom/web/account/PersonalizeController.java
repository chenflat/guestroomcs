package com.managementsystem.guestroom.web.account;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

@Controller
@RequestMapping("/account/personalize")
public class PersonalizeController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(PersonalizeController.class);

	public static final String VIEW_NAME = "account/personalize";

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + PersonalizeController.class);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void processSubmit(@RequestParam MultipartFile file,
			WebRequest request) {
		if(request.getParameterNames()!=null) {
			for(Iterator<String> itKey = request.getParameterNames();itKey.hasNext();) {
				String key = (String)itKey.next();
				logger.info(key);
				if(key!="file") {
					
				}
			}
		}
		
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
