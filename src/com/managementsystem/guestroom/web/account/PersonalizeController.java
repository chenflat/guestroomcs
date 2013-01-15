package com.managementsystem.guestroom.web.account;

import java.io.IOException;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.common.Constants;
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
import com.managementsystem.util.io.FileSystemObject;

/**
 * 账户个性化设置<br />
 * 根据用户属性定义表的字段保存
 * 
 * @author CHENPING
 * */
@Controller
@RequestMapping("/account/personalize")
public class PersonalizeController extends AbstractController implements
		IController {

	private static final Log logger = LogFactory.getLog(PersonalizeController.class);

	public static final String VIEW_NAME = "account/personalize";

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
	 * 语言列表
	 * */
	@ModelAttribute("languages")
	public Set<Listinfo> getLangcodes() {
		return listinfoService.getListEntryItems("Language");
	}

	/**
	 * 时区列表
	 * */
	@ModelAttribute("timezones")
	public Set<Listinfo> getTimezones() {
		return listinfoService.getListEntryItems("TimeZone");
	}

	/**
	 * 季节列表
	 * */
	@ModelAttribute("seasons")
	public Set<Listinfo> getSeasons() {
		return listinfoService.getListEntryItems("Season");
	}

	/**
	 * 服务类型列表
	 * */
	@ModelAttribute("servicerequests")
	public Set<Listinfo> getServiceRequests() {
		return listinfoService.getListEntryItems("Service Request");
	}

	/**
	 * 请求显示个性化设置页
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + PersonalizeController.class);
		ModelAndView mav = new ModelAndView();
		User userinfo = getCurrentUser();
		Set<Userprofile> userprofiles = userprofileService
				.getUserprofileByUsername(userinfo.getUsername(), "personalize");
		userinfo.setUserprofiles(userprofiles);
		mav.addObject("user", userinfo);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 保存或更新个性化设置内容
	 * 
	 * @param file
	 *            文件对象
	 * @request HttpServletRequest
	 * @model Model
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public void processSubmit(HttpServletRequest request, Model model) {
		// 获取个性化设置属性字段
		Set<Profilepropertydefinition> profilepropertydefinitions = profilepropertydefinitionService
				.getProfilepropertiesByCategory("personalize");

		// 上传用户头像
		StringBuilder sb = new StringBuilder();
		StringBuilder exp = new StringBuilder();

		User userinfo = getCurrentUser();
		for (Profilepropertydefinition property : profilepropertydefinitions) {
			String propertyname = property.getPropertyname();
			String value = request.getParameter(propertyname);

			logger.info("key=" + property.getPropertyname() + ",value=" + value);
			boolean isnew = false;
			Userprofile userprofile = userprofileService.getUserprofile(
					userinfo.getUsername(), propertyname);
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
				logger.info("save user profile " + propertyname);

			} else {
				userprofileService.update(userprofile);
				logger.info("update user profile " + propertyname);
			}

		}
		sb.append("successful!");
		Message message = null;
		if (sb.toString().length() > 0) {
			message = new Message(Alert.SUCCESS, sb.toString());
		} else {
			message = new Message(Alert.WARNING, exp.toString());
		}
		model.addAttribute("message", message);

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
