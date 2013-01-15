package com.managementsystem.guestroom.web.account;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.ui.easyui.Resultmsg;


/**
 * 编辑用户名称
 * */
@Controller
@RequestMapping("/account/profile/name")
public class NameController extends AbstractController implements IController {

	private final Log logger = LogFactory.getLog(NameController.class);
	
	private final String VIEW_NAME = "account/profile/name";
	
	@Autowired
	private UserService userService;
	
	/**
	 * 编辑名称
	 * */
	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + NameController.class);
		ModelAndView mav = new ModelAndView();

		User user = getCurrentUser();
		mav.addObject("user", user);
		mav.setViewName(VIEW_NAME);

		return mav;
	}
	
	/**
	 * 保存名称数据
	 * */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processSubmit(WebRequest request) {
		Resultmsg result = new Resultmsg();
		result.setSuccess("false");
		try {
			User user = getCurrentUser();
			for(Iterator<String> it = request.getParameterNames();it.hasNext();) {
				
				String name = it.next();
				String value = request.getParameter(name);
			    logger.info("name:" + name + " value:"+ value);
			    if(!("userId").equals(name)) {
			    	try {
						BeanUtils.setProperty(user, name, value);
					} catch (IllegalAccessException e) {
						logger.error(e);
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						logger.error(e);
						e.printStackTrace();
					}
			    }  
			}

			userService.update(user);
			result.setSuccess("true");
		}catch(Exception e) {
			result.setMsg(e.getLocalizedMessage());
		}
		return result;
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
