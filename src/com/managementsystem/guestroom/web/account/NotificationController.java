package com.managementsystem.guestroom.web.account;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.guestroom.domain.hibernate.Profilepropertydefinition;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.hibernate.Userprofile;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.platform.Message;
import com.managementsystem.guestroom.service.platform.ListinfoService;
import com.managementsystem.guestroom.service.platform.ProfilepropertydefinitionService;
import com.managementsystem.guestroom.service.platform.UserprofileService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;

/**
 * 用户提示操作
 * 
 * @author ping.chen
 * */
@Controller
@RequestMapping("/account/notification")
public class NotificationController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(NotificationController.class);

	public static final String VIEW_NAME = "account/notification";

	/**
	 * 数据字典服务接口对象
	 * */
	@Autowired
	private ListinfoService listinfoService;

	/**
	 * 用户属性定义服务接口对象
	 * */
	@Autowired
	private ProfilepropertydefinitionService profilepropertydefinitionService;

	/**
	 * 用户属性对应资料服务接口对象
	 * */
	@Autowired
	private UserprofileService userprofileService;

	/**
	 * 提示音列表
	 * */
	@ModelAttribute("musics")
	public Set<Listinfo> getSeasons() {
		return listinfoService.getListEntryItems("Music");
	}

	/**
	 * 请求显示用户提示操作界面
	 * 
	 * @return ModelAndView
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + NotificationController.class);
		ModelAndView mav = new ModelAndView();
		User userinfo = getCurrentUser();
		Set<Userprofile> userprofiles = userprofileService
				.getUserprofileByUsername(userinfo.getUsername(),"notification");
		userinfo.setUserprofiles(userprofiles);
		mav.addObject("user", userinfo);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 保存或更新个性化设置内容
	 * 
	 * @request HttpServletRequest
	 * @model Model
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public void processSubmit(HttpServletRequest request, Model model) {
		// 获取提示设置属性字段
		Set<Profilepropertydefinition> profilepropertydefinitions = profilepropertydefinitionService
				.getProfilepropertiesByCategory("notification");
		try {
			// 当前操作用户
			User userinfo = getCurrentUser();
			for (Profilepropertydefinition property : profilepropertydefinitions) {
				// 属性
				String propertyname = property.getPropertyname();
				// 值
				String value = request.getParameter(propertyname);
				logger.info(String.format("key=%s,value=%s", property.getPropertyname(),value));
				boolean isnew = false;
				Userprofile userprofile = userprofileService.getUserprofile(userinfo.getUsername(),propertyname);
				if (userprofile == null) {
					userprofile = new Userprofile();
					isnew = true;
				}
				userprofile.setLastupdateddate(Calendar.getInstance().getTime());
				userprofile.setProfilepropertydefinition(property);
				userprofile.setPropertyvalue(value);
				userprofile.setUser(userinfo);
				userprofile.setVisibility(0);
				if (isnew) {
					userprofileService.save(userprofile);
					logger.info("save user notification " + propertyname);
				} else {
					userprofileService.update(userprofile);
					logger.info("update user notification " + propertyname);
				}
			}
			model.addAttribute("message", new Message(Alert.SUCCESS,
					"successful!"));
		} catch (Exception e) {
			model.addAttribute("message",
					new Message(Alert.WARNING, e.getMessage()));
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
